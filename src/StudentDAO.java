package student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {


    // CREATE
    public void addStudent(Student student) {


        String sql =
                "INSERT INTO students(name, email, age, course) " +
                "VALUES (?, ?, ?, ?)";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getCourse());


            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    // READ
    public List<Student> getAllStudents() {


        List<Student> students = new ArrayList<>();


        String sql = "SELECT * FROM students";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {


                Student student = new Student();


                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setAge(rs.getInt("age"));
                student.setCourse(rs.getString("course"));


                students.add(student);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return students;
    }




    // READ ONE
    public Student getStudentById(int id) {


        Student student = null;


        String sql =
                "SELECT * FROM students WHERE id = ?";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();


            if (rs.next()) {


                student = new Student();


                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setAge(rs.getInt("age"));
                student.setCourse(rs.getString("course"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return student;
    }




    // UPDATE
    public void updateStudent(Student student) {


        String sql =
                "UPDATE students SET name=?, email=?, age=?, course=? " +
                "WHERE id=?";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getCourse());
            ps.setInt(5, student.getId());


            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    // DELETE
    public void deleteStudent(int id) {


        String sql =
                "DELETE FROM students WHERE id=?";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setInt(1, id);


            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
