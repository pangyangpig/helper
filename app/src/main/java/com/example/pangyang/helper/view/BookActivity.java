package com.example.pangyang.helper.view;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;

import com.example.pangyang.helper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookActivity extends BaseActivity {

    @Bind(R.id.sv_search) SearchView searchView;
    private BaseFragment fragment = BooksListFragment.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ButterKnife.bind(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fragment.doSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        addFragment(fragment);
    }

    private void addFragment(BaseFragment fragment){
        this.fragment = fragment;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_content,fragment);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.iv_back)
    void onClick(){
        onBackPressed();
    }

}
