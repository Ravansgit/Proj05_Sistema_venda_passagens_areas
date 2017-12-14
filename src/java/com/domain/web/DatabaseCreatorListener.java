package com.domain.web;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseCreatorListener implements ServletContextListener {
    /*private void createHourPriceTable(Statement s){
        try{
            s.execute(  "CREATE TABLE hour_price(\n" +
                        "    id INTEGER NOT NULL GENERATED ALWAYS \n" +
                        "        AS IDENTITY (START WITH 1, INCREMENT BY 1)\n" +
                        "    , datetime timestamp not null\n" +
                        "    , price numeric(10,2) not null\n" +
                        ")");
            System.out.println("Criada tabela hour_price.");
        }catch(Exception ex2){
            System.out.println("Ero ao criar a hour_price: "+ex2.getMessage());
        }
    }
    */
    private void createCategoriaVoo(Statement s) {
        try {
            s.execute("CREATE TABLE categoria_voo(\n"
                    + "    id INTEGER NOT NULL GENERATED ALWAYS \n"
                    + "        AS IDENTITY (START WITH 1, INCREMENT BY 1)\n"
                    + "    , categoria numeric(2) not null\n"
                    + "    , categoria_voo varchar(50) not null\n"
                    + ")");
            System.out.println("Criada tabela categoria_voo.");
        } catch (Exception ex2) {
            System.err.println("Erro ao criar a categoria_voo: " + ex2.getMessage());
        }
    }
    
    /*private void createUsersTable(Statement s){
        try{
            s.execute(  "CREATE TABLE users(\n" +
                        "    id INTEGER NOT NULL GENERATED ALWAYS \n" +
                        "        AS IDENTITY (START WITH 1, INCREMENT BY 1)\n" +
                        "    , name varchar(200) not null\n" +
                        "    , login varchar(50)  not null\n" +
                        "    , pass_hash varchar(200) not null\n" +
                        ")");
            System.out.println("Criada tabela users.");
            s.execute("INSERT INTO users VALUES("
                + "default"
                + ", 'Administrador do Sistema'"
                + ", 'admin@gmail.com'"
                + ", '"+"1234".hashCode()+"'"
                + ")");
            System.out.println("Usuário admin criado com a senha '1234'.");
        }catch(Exception ex2){
            System.out.println("Ero ao criar a users: "+ex2.getMessage());
        }
    }*/
    private void createUsersTable(Statement s) {
        try {
            s.execute("CREATE TABLE users(\n"
                    + "    CPF INTEGER not null\n"
                    + "    , name varchar(75) not null\n"
                    + "    , login varchar(50)  not null\n"
                    + "    , nacionalidade varchar(45) not null\n"
                    + "    , genero varchar(11) not null\n" 
                    + "    , telefone integer not null\n"
                    + "    , dt_nascimento varchar(50)  not null\n" 
                    + "    , pass_hash varchar(200) not null\n" +
                    ")");
            System.out.println("Criada tabela users.");
            s.execute("INSERT INTO users VALUES("
                    + "11111111111"
                    + ", 'Administrador do Sistema'"
                    + ", 'admin@gmail.com'"
                    + ", 'Brasileiro'"
                    + ", 'Masculino'"
                    + ", '1112345678'"                    
                    +", '02/02/2017'"
                    + ", '"+"1234".hashCode()+"'"
                    + ")");
            System.out.println("Usuário admin criado com senha 1234");
        } catch (Exception ex2) {
            System.err.println("Erro ao criar a users: " + ex2.getMessage());
        }
    }
    
    /*private void createVehicleStaysTable(Statement s){
        try{
            s.execute(  "CREATE TABLE vehicles_stays(\n" +
                        "    id  INTEGER NOT NULL GENERATED ALWAYS \n" +
                        "        AS IDENTITY (START WITH 1, INCREMENT BY 1)\n" +
                        "    , vehicle_model varchar(50) not null\n" +
                        "    , vehicle_color varchar(20) not null\n" +
                        "    , vehicle_plate varchar(7) not null\n" +
                        "    , begin_stay timestamp not null\n" +
                        "    , end_stay timestamp\n" +
                        "    , price numeric(10,2)\n" +
                        ")");
            System.out.println("Criada tabela vehicles_stays.");
        }catch(Exception ex2){
            System.out.println("Ero ao criar a vehicles_stays: "+ex2.getMessage());
        }
    }*/
    
    private void createVooTable(Statement s) {
        try {
            s.execute("CREATE TABLE voo(\n"
                    + "      cv INTEGER NOT NULL GENERATED ALWAYS \n"
                    + "        AS IDENTITY (START WITH 1, INCREMENT BY 1)\n"
                    + "    , id_origem_voo varchar(50) not null\n"
                    + "    , id_destino_voo varchar(50)  not null\n"
                    + "    , voo numeric(4)\n"
                    + "    , acentos numeric(4)\n"
                    + "    , ct_voo  numeric(2)\n"
                    + "    , dateida timestamp not null\n"
                    + "    , hourida timestamp not null\n"
                    + ")");
            System.out.println("Criada tabela Voo.");
        } catch (Exception ex2) {
            System.err.println("Erro ao criar a Voo: " + ex2.getMessage());
        }
    }

    private void createLocalTable(Statement s) {
        try {
            s.execute("CREATE TABLE local(\n"
                    + "      local INTEGER NOT NULL GENERATED ALWAYS \n"
                    + "        AS IDENTITY (START WITH 1, INCREMENT BY 1)\n"
                    + "    , name varchar(50) not null\n"
                    + ")");
            System.out.println("Criada tabela Local.");
        } catch (Exception ex2) {
            System.err.println("Erro ao criar a tabela Local: " + ex2.getMessage());
        }
    }
    

    private void createVooUsuarioTable(Statement s) {
        try {
            s.execute("CREATE TABLE voo_usuario(\n"
                    + "      cadeivoo INTEGER NOT NULL GENERATED ALWAYS \n"
                    + "        AS IDENTITY (START WITH 1, INCREMENT BY 1)\n"
                    + "    , idVoo numeric(5) not null\n"
                    + "    , idUsu numeric(11) not null\n"
                    + "    , qtAdul numeric(2) not null\n"
                    + "    , qtCrianca numeric(2) not null\n"
                    + ")");
            
            System.out.println("Criada tabela voo_usuario.");
        }catch(Exception ex2){
            System.err.println("Erro ao criar a voo_usuario: "+ ex2.getMessage());
        }
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String url = "jdbc:derby:c:/derby/WebParkingDb;create=true";
            Connection c =DriverManager.getConnection(url);
            Statement s = c.createStatement();
            System.out.println(new Date());
            System.out.println("Iniciando a criação do BD.");
            createCategoriaVoo(s);
            createUsersTable(s);
            createVooTable(s);
            createLocalTable(s);
            createVooUsuarioTable(s);
            s.close();
            c.close();
            DriverManager.getConnection
            ("jdbc:derby:c:/derby/WebParkingDb;shutdown=true");
        }catch(Exception ex){
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}