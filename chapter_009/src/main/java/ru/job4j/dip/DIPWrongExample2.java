package ru.job4j.dip;

public class DIPWrongExample2 {
    class PostgreSQLConnection {
        public void connect() {
            System.out.println("Connect to PostgreSQL");
        }
    }

    class DataBaseConnection {
        private PostgreSQLConnection postgreSQLConnection;

        public DataBaseConnection(PostgreSQLConnection postgreSQLConnection) {
            this.postgreSQLConnection = postgreSQLConnection;
        }

        public void connect() {
            postgreSQLConnection.connect();
        }
    }

    /*
     * Класс DataBaseConnection зависит от конкретного класса PostgreSQLConnection, и может подключиться
     * только к базе данных PostgreSQL.
     * Это является нарушением принципа DIP.
     * */
}
