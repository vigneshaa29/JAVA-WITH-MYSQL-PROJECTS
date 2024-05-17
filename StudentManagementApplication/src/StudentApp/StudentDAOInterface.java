package StudentApp;

public interface StudentDAOInterface {
    public boolean insertStudent(Student s);
    public void showAllStudent();
    public boolean showStudentById(int roll);
    public boolean update(int roll,String update,int ch);
    public boolean delete(int roll);
}
