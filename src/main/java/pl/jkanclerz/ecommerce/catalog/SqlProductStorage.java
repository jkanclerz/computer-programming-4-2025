package pl.jkanclerz.ecommerce.catalog;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SqlProductStorage implements ProductStorage {

    private final JdbcTemplate jdbcTemplate;

    public SqlProductStorage(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> allProducts() {
        List<Product> result = jdbcTemplate.query(
                "SELECT * FROM `product_catalog__products`",
                (rs, i) -> {
                    var product = new Product(
                            UUID.fromString(rs.getString("ID")),
                            rs.getString("NAME"),
                            rs.getString("NAME") // Consider if this duplication is intentional
                    );

                    product.changePrice(rs.getBigDecimal("PRICE"));

                    return product;
                }
        );
        return result;
    }

    @Override
    public void add(Product product) {
        var sql = """
            INSERT INTO `product_catalog__products` (id, name, description, price)
            VALUES
                (:id, :name, :desc, :price)
        """;

        Map<String, Object> params = new HashMap<>();
        params.put("id", product.getId());
        params.put("name", product.getName());
        params.put("desc", product.getName());
        params.put("price", product.getPrice());

        var namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public Product getProductBy(String id) {
        var result = jdbcTemplate.queryForObject(
                "select * from `product_catalog__products` where ID = ?",
                new Object[]{id},
                (rs, i) -> {
                    var product = new Product(
                            UUID.fromString(rs.getString("ID")),
                            rs.getString("NAME"),
                            rs.getString("NAME")
                    );

                    product.changePrice(rs.getBigDecimal("PRICE"));

                    return product;
                });

        return result;

    }

}
