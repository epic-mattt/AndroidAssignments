import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.acer.androidassignments.R;

import java.util.zip.Inflater;

public class MessageFragment extends Fragment {

    View message_detail_layout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View superView = super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.chat_message_details, null);
    }
}
