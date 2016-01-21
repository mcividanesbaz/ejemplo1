package com.example.marcos.examen20;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.example.marcos.examen20.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private DummyContent.DummyItem mItem;

    private OnItemSelectedListener listener;

    public ItemDetailFragment() {
    }

    listener.enviarOK("OK");




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
            Button btnBorrar = (Button) rootView.findViewById(R.id.btnBorrar);
            btnBorrar.setOnClickListener(new View.OnClickListener() {
                           @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
                          @Override
                           public void onClick(View v) {
                                           ((TextView) v.findViewById(R.id.objeto_detail)).setText("");
                                            if (rootView == null || !rootView.isInLayout()) {
                                            getActivity().finish();
                                        } else {

                                              }
                                }
                       });
        }
    }

    public interface OnItemSelectedListener {
                public void enviarOK(String link);
            }

                @Override
        public void onAttach(Activity context) {
                super.onAttach(context);
                if (context instanceof OnItemSelectedListener) {
                        listener = (OnItemSelectedListener) context;
                    } else {
                        throw new ClassCastException(context.toString()
                                      + " must implement MyListFragment.OnItemSelectedListener");
                    }
            }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);
        }

        return rootView;
    }
}

