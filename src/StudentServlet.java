package student;
import javax.servlet.ServletException;
import javax.servlet.http.*;


import java.io.IOException;
import java.util.List;


public class StudentServlet extends HttpServlet {


    private StudentDAO dao;


    @Override
    public void init() {
        dao = new StudentDAO();
    }




    // READ / EDIT / DELETE
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {


        String action = request.getParameter("action");


        if (action == null) {
            action = "list";
        }




        if (action.equals("list")) {


            List<Student> students =
                    dao.getAllStudents();


            request.setAttribute("students", students);


            request.getRequestDispatcher("list.jsp")
                   .forward(request, response);
        }




        else if (action.equals("edit")) {


            int id =
                    Integer.parseInt(request.getParameter("id"));


            Student student =
                    dao.getStudentById(id);


            request.setAttribute("student", student);


            request.getRequestDispatcher("edit.jsp")
                   .forward(request, response);
        }




        else if (action.equals("delete")) {


            int id =
                    Integer.parseInt(request.getParameter("id"));


            dao.deleteStudent(id);


            response.sendRedirect("students?action=list");
        }
    }




    // CREATE / UPDATE
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {


        String action =
                request.getParameter("action");




        if (action.equals("add")) {


            String name =
                    request.getParameter("name");


            String email =
                    request.getParameter("email");


            int age =
                    Integer.parseInt(
                            request.getParameter("age"));


            String course =
                    request.getParameter("course");




            Student student =
                    new Student(
                            name,
                            email,
                            age,
                            course
                    );


            dao.addStudent(student);


            response.sendRedirect(
                    "students?action=list"
            );
        }




        else if (action.equals("update")) {


            int id =
                    Integer.parseInt(
                            request.getParameter("id"));


            String name =
                    request.getParameter("name");


            String email =
                    request.getParameter("email");


            int age =
                    Integer.parseInt(
                            request.getParameter("age"));


            String course =
                    request.getParameter("course");




            Student student =
                    new Student(
                            id,
                            name,
                            email,
                            age,
                            course
                    );


            dao.updateStudent(student);


            response.sendRedirect(
                    "students?action=list"
            );
        }
    }
}
