package model.service;

import javax.servlet.http.HttpServletRequest;

public class PaginationService {
    private static final int RECORDS_PER_PAGE = 10;
    private static volatile PaginationService instance;

    private PaginationService() {

    }

    public static PaginationService getInstance() {
        if (instance == null) {
            synchronized (PaginationService.class) {
                if(instance == null) {
                    instance = new PaginationService();
                }
            }
        }
        return instance;
    }

    public static String paginate(int currentPage, String tableName) {
        String query = "SELECT * FROM " + tableName + " LIMIT ";
        switch (currentPage) {
            case 1:
                query += RECORDS_PER_PAGE;
                break;
            default:
                query += (currentPage - 1) * RECORDS_PER_PAGE + ", " + RECORDS_PER_PAGE;
                break;
        }
        return query;
    }

    public static int getCurrentPage(HttpServletRequest request) {
        String page = request.getParameter("page");
        int currentPage;

        if(page == null) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(page);
        }
        return currentPage;
    }
}
