package ru.job4j.pojo;

public class Shop {
    public Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = 0; i < products.length - 1; i++) {
            if (products[i] == null) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Meat", 2);
        products[4] = new Product("Beer", 20);
        System.out.println("Имеется список продуктов:");
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (products[i] != null) {
                System.out.println(product.getName() + ": " + product.getCount() + " pieces.");
            } else {
                System.out.println("null");
            }
        }

        System.out.println("\nУдаляем из списка молоко:");
        shop.delete(products, 0);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (products[i] != null) {
                System.out.println(product.getName() + ": " + product.getCount() + " pieces.");
            } else {
                System.out.println("null");
            }
        }
    }
}
