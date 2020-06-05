package cat.urv.deim.asm.p3.shared;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsDetailActivity extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> mText;

    public NewsDetailActivity() {
        mText = new MutableLiveData<>();
        mText.setValue("This News fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
