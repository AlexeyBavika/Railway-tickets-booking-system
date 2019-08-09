package model.entity;

public enum PlaceType {
    BERTH {
        @Override
        public String toString() {
            return "berth";
        }
    },

    COUPE {
        @Override
        public String toString() {
            return "coupe";
        }
    },

    DELUXE {
        @Override
        public String toString() {
            return "deluxe";
        }
    }
}
