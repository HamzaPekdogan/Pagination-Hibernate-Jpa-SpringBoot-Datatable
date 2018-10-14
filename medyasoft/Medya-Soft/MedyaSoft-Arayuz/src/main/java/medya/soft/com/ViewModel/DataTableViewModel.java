package medya.soft.com.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataTableViewModel extends DataTableResultInfo { // datatable isteğine uygun model
    private List<List<String>> data;

    public DataTableViewModel() {
        this.data = new ArrayList<>();
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
