package bean;

import java.util.List;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:56
 *@Description:${DESCRIPTION}
 **/public class Beanl {


    private int code;
    private List<OrderDataBean> orderData;

    @Override
    public String toString() {
        return "Beanl{" +
                "code=" + code +
                ", orderData=" + orderData +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<OrderDataBean> getOrderData() {
        return orderData;
    }

    public void setOrderData(List<OrderDataBean> orderData) {
        this.orderData = orderData;
    }

    public static class OrderDataBean {


        private int shopId;
        private String shopName;
        private List<CartlistBean> cartlist;



        @Override
        public String toString() {
            return "OrderDataBean{" +
                    "shopId=" + shopId +
                    ", shopName='" + shopName + '\'' +
                    ", cartlist=" + cartlist +
                    '}';
        }



        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public List<CartlistBean> getCartlist() {
            return cartlist;
        }

        public void setCartlist(List<CartlistBean> cartlist) {
            this.cartlist = cartlist;
        }

        public static class CartlistBean {

            private int id;
            private int shopId;
            private String shopName;
            private String defaultPic;
            private int productId;
            private String productName;
            private String color;
            private String meal;
            private int price;
            private int count;
            private boolean statu;
            @Override
            public String toString() {
                return "CartlistBean{" +
                        "id=" + id +
                        ", shopId=" + shopId +
                        ", shopName='" + shopName + '\'' +
                        ", defaultPic='" + defaultPic + '\'' +
                        ", productId=" + productId +
                        ", productName='" + productName + '\'' +
                        ", color='" + color + '\'' +
                        ", meal='" + meal + '\'' +
                        ", price=" + price +
                        ", count=" + count +
                        '}';
            }

            public boolean isStatu() {
                return statu;
            }

            public void setStatu(boolean statu) {
                this.statu = statu;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getDefaultPic() {
                return defaultPic;
            }

            public void setDefaultPic(String defaultPic) {
                this.defaultPic = defaultPic;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getMeal() {
                return meal;
            }

            public void setMeal(String meal) {
                this.meal = meal;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}
