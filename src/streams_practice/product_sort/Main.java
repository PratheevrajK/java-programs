package streams_practice.product_sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //        Product p1 = new Product(null, "Loan", LocalDate.of(2026, 2, 26)); // NPE would be thrown.

        Product p1 = new Product("Residential", "Loan", LocalDate.of(2026, 2, 10));
        Product p2 = new Product("Residential", "Loan", LocalDate.of(2026, 2, 10)); // Duplicate entry.
        Product p3 = new Product("Residential", "Loan", LocalDate.of(2026, 2, 26));
        Product p4 = new Product("Residential", "Loan", LocalDate.of(2026, 1, 5));
        Product p5 = new Product("Warehouse", "Loan", LocalDate.of(2025, 12, 31));
        Product p6 = new Product("Warehouse", "Loan", LocalDate.of(2026, 1, 15));
        Product p7 = new Product("Bid", "Stock", LocalDate.of(2025, 7, 1));
        Product p8 = new Product("Residential", "Loan", null);
        Product p9 = new Product("Bid", "Stock", null);

        List<Product> products = new ArrayList<>(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9));

        List<Product> dedupedAndSorted = processProduct(products);

        dedupedAndSorted.forEach(System.out::println);
    }

    public static List<Product> processProduct(List<Product> products) {
        // 1) Remove duplicates using equals/hashCode (via distinct()).
        // 2) Sort by type and then by name and then by effectiveDate desc (nulls last just in case).
        List<Product> dedupedAndSorted = products.stream()
                .distinct()
                .sorted(Comparator.comparing(Product::getType)
                                .thenComparing(Product::getName)
                                .thenComparing(Product::getEffectiveDate, Comparator.nullsLast(Comparator.reverseOrder()))
                        )
                .collect(Collectors.toList());
        return dedupedAndSorted;
    }
}

class Product {
    private String name;
    private String type;
    private LocalDate effectiveDate;

    public Product(String name, String type, LocalDate effectiveDate) {
        this.name = Objects.requireNonNull(name);
        this.type = Objects.requireNonNull(type);
        this.effectiveDate = effectiveDate;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product p = (Product) o;
        return Objects.equals(name, p.getName())
                && Objects.equals(type, p.getType())
                && Objects.equals(effectiveDate, p.getEffectiveDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, effectiveDate);
    }

    @Override
    public String toString() {
        return String.format("%s is a %s effective from %s", name, type, effectiveDate);
    }
}
