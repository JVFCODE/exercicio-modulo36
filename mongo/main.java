package com.example;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        ActivityDAO activityDAO = new ActivityDAO();

        // Adicionando usuários
        userDAO.addUser("João Silva", "joao.silva@example.com");
        userDAO.addUser("Maria Oliveira", "maria.oliveira@example.com");

        // Listando usuários
        userDAO.listUsers();

        // Registrando atividades
        activityDAO.logActivity(1, "login");
        activityDAO.logActivity(2, "logout");

        // Listando atividades
        activityDAO.listActivities();
    }
}
