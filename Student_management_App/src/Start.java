import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Com.Student.Manage.Student;
import Com.Student.Manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("welcome to Student management App ....");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Press 1 to Add students");
			System.out.println("Press 2 to delete students");
			System.out.println("Press 3 to display students");
			System.out.println("press 4 to exit ");

			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				// Add student code
				System.out.println("Enter the Student name:");
				String name = br.readLine();
				System.out.println("Enter the student phone no:");
				String phone = br.readLine();
				System.out.println("Enter student city:");
				String city = br.readLine();

				// create student object to store student information.

				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.InsertStudentDataToDb(st);
				if (answer) {
					System.out.println("Student added Successfully...");
				} else {
					System.out.println("Something went wrong..........");
				}

				System.out.println(st);

			} else if (c == 2) {
				// delete student code
				System.out.println("Enter Student id for delete..");
				int userId = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				
				if (f) {
					System.out.println("Student delete successfully");
				} else {
					System.out.println("Something went wrong");
				}

			} else if (c == 3) {
				// Display code
				StudentDao.ShowAllStudent();
			} else if (c == 4) { 
				// exit code
				break;
			} else {

			}

		}
		System.out.println("Thankyou for using my application ....");
		System.out.println("byy byy....see you soon");
	}

}
