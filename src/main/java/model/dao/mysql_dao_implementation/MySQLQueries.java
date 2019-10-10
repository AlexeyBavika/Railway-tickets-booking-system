package model.dao.mysql_dao_implementation;

public class MySQLQueries {
    static final String CREATE_USER = "INSERT INTO users (name, surname, email, password, phone, role_id) VALUES (?, ?, ?, ?, ?, ?)";
    static final String DELETE_USER = "DELETE FROM users WHERE users.id = ?";
    static final String UPDATE_USER_ROLE = "UPDATE users SET users.role_id = ? WHERE users.id = ?";
    static final String GET_ALL_USER_EMAILS = "SELECT email FROM users";
    static final String GET_ALL_USER_PHONES = "SELECT phone FROM users";
    static final String GET_USER_ROLE_ID = "SELECT role_id FROM users WHERE users.email = ?";
    static final String GET_USER = "SELECT id, name, surname, password, phone, role_id FROM users WHERE users.email = ?";

    static final String CREATE_TRAIN = "INSERT INTO trains (route_id, berth_num, coupe_num, deluxe_num) VALUES (?, ?, ?, ?)";
    static final String DELETE_TRAIN = "DELETE FROM trains WHERE trains.id = ?";
    static final String GET_TRAINS_BY_ROUTE_ID = "SELECT * FROM trains WHERE trains.route_id = ?";

    static final String CREATE_ROUTE = "INSERT INTO routes (departure_station, departure_time, destination_station, destination_time) VALUES (?, ?, ?, ?)";
    static final String DELETE_ROUTE = "DELETE FROM routes WHERE routes.id = ?";
    static final String GET_ROUTE_BY_ID = "SELECT * FROM routes WHERE routes.id = ?";
    static final String GET_ROUTES_FROM_DATE = "SELECT * FROM routes WHERE routes.departure_time > ? LIMIT";
    static final String GET_ROUTES_FROM_CONCRETE_STATION = "SELECT * FROM routes WHERE routes.departure_station = ? AND routes.destination_station = ?";

    static final String CREATE_PRICE = "INSERT INTO prices (route_id, berth_price, coupe_price, deluxe_price) VALUES (?, ?, ?, ?)";
    static final String DELETE_PRICE = "DELETE FROM prices WHERE prices.id = ?";
    static final String GET_PRICE_BY_ROUTE_ID = "SELECT * FROM prices WHERE prices.route_id = ?";

    static final String CREATE_ORDER = "INSERT INTO orders (passenger_id, train_id, place_type, price) VALUES (?, ?, ?, ?)";
    static final String DELETE_ORDER = "DELETE FROM orders WHERE orders.id = ?";
    static final String GET_ALL_ORDERS_BY_ID = "SELECT * FROM orders WHERE orders.passenger_id = ? LIMIT";

    static final String CREATE_CHANGE_ROLE_REQUEST = "INSERT INTO change_role_requests (user_id, text) VALUES (?, ?)";
    static final String DELETE_CHANGE_ROLE_REQUEST = "DELETE FROM change_role_requests WHERE change_role_requests.id = ?";
}
