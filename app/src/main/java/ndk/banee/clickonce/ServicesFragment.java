package ndk.banee.clickonce;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ndk.banee.clickonce.dummy.ServiceList;
import ndk.banee.clickonce.dummy.ServiceList.ServiceItem;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link ServiceFragmentInteractionListener}
 * interface.
 */
public class ServicesFragment extends Fragment {

    private ServiceFragmentInteractionListener serviceFragmentInteractionListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ServicesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_services_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {

            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            recyclerView.setAdapter(new ServicesRecyclerViewAdapter(ServiceList.serviceList, serviceFragmentInteractionListener));
        }
        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);

        if (context instanceof ServiceFragmentInteractionListener) {

            serviceFragmentInteractionListener = (ServiceFragmentInteractionListener) context;

        } else {

            throw new RuntimeException(context.toString() + " must implement ServiceFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {

        super.onDetach();
        serviceFragmentInteractionListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface ServiceFragmentInteractionListener {

        void onFragmentInteraction(ServiceItem serviceItem);
    }
}
