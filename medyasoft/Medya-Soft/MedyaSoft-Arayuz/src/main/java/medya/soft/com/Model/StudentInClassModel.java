package medya.soft.com.Model;

import zendemFramework.AltyapiModel.Model.Model;

public class StudentInClassModel extends Model {
    private String studentUuid;
    private String studentClassUuid;

    public String getStudentUuid() {
        return studentUuid;
    }

    public void setStudentUuid(String studentUuid) {
        this.studentUuid = studentUuid;
    }

    public String getStudentClassUuid() {
        return studentClassUuid;
    }

    public void setStudentClassUuid(String studentClassUuid) {
        this.studentClassUuid = studentClassUuid;
    }
}
