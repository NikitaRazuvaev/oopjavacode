package oopjavacode.Semenar1;

    
    public abstract class Product {
        private String name;
        private int price;
        private int id;
        private int massa;

        
        Product(int id, String name, int price, int massa){
            this.name = name;
            this.id = id;
            this.price = price;
            this.massa = massa;

        }
        public String getName() {
            return name;
        }
        public int getId() {
            return id;
        }
        public int getPrice() {
            return price;
        }
        public int getMassa() {
            return massa;
        }
        @Override 
        public abstract String toString();

        

        
    }
