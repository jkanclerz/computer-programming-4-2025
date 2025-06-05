package pl.jkanclerz.ecommerce.playground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SqlTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setupDatabase() {
        var dropSql = "DROP TABLE `product_catalog__products` IF EXISTS";
        jdbcTemplate.execute(dropSql);

        var sql = """
            CREATE TABLE `product_catalog__products` (
                id VARCHAR(100) NOT NULL,
                name VARCHAR(100) NOT NULL,
                description VARCHAR(100) NOT NULL,
                price DECIMAL(12,2),
                cover VARCHAR(100),
                PRIMARY KEY(id)
            );
        """;
        jdbcTemplate.execute(sql);
    }
    @Test
    void itQueryDatabase() {
        var sql = """
            Select now() curr_date;
        """;

        var result = jdbcTemplate.queryForObject(sql, String.class);

        assertThat(result).contains("2025");
    }

    @Test
    void itCreatesTable() {
        var dropSql = "DROP TABLE `product_catalog__products` IF EXISTS";
        jdbcTemplate.execute(dropSql);

        var sql = """
            CREATE TABLE `product_catalog__products` (
                id VARCHAR(100) NOT NULL,
                name VARCHAR(100) NOT NULL,
                description VARCHAR(100) NOT NULL,
                price DECIMAL(12,2),
                cover VARCHAR(100),
                PRIMARY KEY(id)
            );
        """;
        jdbcTemplate.execute(sql);

        var result = jdbcTemplate.queryForObject("Select count(*) from `product_catalog__products`", Integer.class);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void itAllowsInsertRecords() {
        var sql = """
            INSERT INTO `product_catalog__products` (id, name, description, price)
            VALUES
                ('0280a9d9-f477-4be5-94bf-0cff163ef357', 'X product', 'nice one', 10.10),
                ('1344e377-26ab-4632-adf7-9a23b3652b24', 'Y product', 'nicer', 20.10)
        """;
        jdbcTemplate.execute(sql);

        var result = jdbcTemplate.queryForObject("Select count(*) from `product_catalog__products`", Integer.class);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void itInsertDynamic() {
        var sql = """
            INSERT INTO `product_catalog__products` (id, name, description, price)
            VALUES
                (?, ?, ?, ?)
        """;
        jdbcTemplate.update(sql, "myId", "myName", "myDesc", BigDecimal.valueOf(10.10));

        var result = jdbcTemplate.queryForObject("Select count(*) from `product_catalog__products`", Integer.class);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void itInsertDynamicAsNamed() {
        var sql = """
            INSERT INTO `product_catalog__products` (id, name, description, price)
            VALUES
                (:id, :name, :desc, :price)
        """;

        Map<String, Object> params = new HashMap<>();
        params.put("id", "myId");
        params.put("name", "myName");
        params.put("desc", "myDesc");
        params.put("price", BigDecimal.valueOf(10.10));

        var namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedParameterJdbcTemplate.update(sql, params);

        var result = jdbcTemplate.queryForObject("Select count(*) from `product_catalog__products`", Integer.class);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void selectForAll() {
        var sql = """
            INSERT INTO `product_catalog__products` (id, name, description, price)
            VALUES
                ('0280a9d9-f477-4be5-94bf-0cff163ef357', 'X product', 'nice one', 10.10),
                ('1344e377-26ab-4632-adf7-9a23b3652b24', 'Y product', 'nicer', 20.10)
        """;
        jdbcTemplate.execute(sql);

        var result = jdbcTemplate.queryForList("select * from `product_catalog__products`");

        assertThat(result)
                .hasSize(2)
                .extracting("NAME")
                .containsAll(Arrays.asList("X product", "Y product"));
    }

    @Test
    void selectForAllMapToClass() {
        var sql = """
            INSERT INTO `product_catalog__products` (id, name, description, price)
            VALUES
                ('0280a9d9-f477-4be5-94bf-0cff163ef357', 'X product', 'nice one', 10.10),
                ('1344e377-26ab-4632-adf7-9a23b3652b24', 'Y product', 'nicer', 20.10)
        """;
        jdbcTemplate.execute(sql);

        var result = jdbcTemplate.queryForList("select * from `product_catalog__products`");

        assertThat(result)
                .hasSize(2)
                .extracting("NAME")
                .containsAll(Arrays.asList("X product", "Y product"));
    }

    @Test
    void selectForSingle() {
        var sql = """
            INSERT INTO `product_catalog__products` (id, name, description, price)
            VALUES
                ('0280a9d9-f477-4be5-94bf-0cff163ef357', 'X product', 'nice one', 10.10),
                ('1344e377-26ab-4632-adf7-9a23b3652b24', 'Y product', 'nicer', 20.10)
        """;
        jdbcTemplate.execute(sql);

        var result = jdbcTemplate.queryForObject(
                "select * from `product_catalog__products` where name = ?",
                new Object[]{"X product"},
                (rs, i) -> {
                    var product = new ProductData();
                    product
                            .setId(rs.getString("ID"))
                            .setName(rs.getString("NAME"))
                            .setDescription(rs.getString("DESCRIPTION"))
                            .setPrice(rs.getBigDecimal("PRICE"));
                    return product;
                });

        assertThat(result)
                .isInstanceOf(ProductData.class)
                .extracting("name", "description", "price")
                .containsExactly("X product", "nice one", new BigDecimal("10.10"));
    }

    @Test
    void deleteFromTable() {
        var sql = """
            INSERT INTO `product_catalog__products` (id, name, description, price)
            VALUES
                ('0280a9d9-f477-4be5-94bf-0cff163ef357', 'X product', 'nice one', 10.10),
                ('1344e377-26ab-4632-adf7-9a23b3652b24', 'Y product', 'nicer', 20.10)
        """;
        jdbcTemplate.execute(sql);

        jdbcTemplate.update("delete from `product_catalog__products` where name = ?", "Y product");

        var result = jdbcTemplate.queryForObject("Select count(*) from `product_catalog__products`", Integer.class);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void itUpdateRecord() {
        var sql = """
            INSERT INTO `product_catalog__products` (id, name, description, price)
            VALUES
                ('0280a9d9-f477-4be5-94bf-0cff163ef357', 'X product', 'nice one', 10.10),
                ('1344e377-26ab-4632-adf7-9a23b3652b24', 'Y product', 'nicer', 20.10)
        """;
        jdbcTemplate.execute(sql);

        jdbcTemplate.update(
                "UPDATE `product_catalog__products` SET name = ?, description = ? where id = ?",
                "Z product",
                "Z description",
                "0280a9d9-f477-4be5-94bf-0cff163ef357"
        );

        var result = jdbcTemplate.queryForObject(
                "Select count(*) from `product_catalog__products` where name = ?",
                new Object[]{"Z product"},
                Integer.class);

        assertThat(result).isEqualTo(1);
    }

    class ProductData {
        private String id;
        private String name;
        private String description;
        private BigDecimal price;

        ProductData() {
        }

        public String getId() {
            return id;
        }

        public ProductData setId(String id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public ProductData setName(String name) {
            this.name = name;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public ProductData setDescription(String description) {
            this.description = description;
            return this;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public ProductData setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }
    }
}
