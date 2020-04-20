package ndk.banee.clickonce;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ndk.banee.clickonce.ServiceList.ServiceItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ServiceItem} and makes a call to the
 * specified {@link ServicesFragment.ServiceFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ServicesRecyclerViewAdapter extends RecyclerView.Adapter<ServicesRecyclerViewAdapter.ViewHolder> {

    private final List<ServiceItem> serviceList;
    private final ServicesFragment.ServiceFragmentInteractionListener serviceFragmentInteractionListener;

    ServicesRecyclerViewAdapter(List<ServiceItem> serviceList, ServicesFragment.ServiceFragmentInteractionListener serviceFragmentInteractionListener) {

        this.serviceList = serviceList;
        this.serviceFragmentInteractionListener = serviceFragmentInteractionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = serviceList.get(position);
        holder.buttonService.setText(serviceList.get(position).id);

        holder.listItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (null != serviceFragmentInteractionListener) {

                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    serviceFragmentInteractionListener.onFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final View listItem;
        final Button buttonService;
        ServiceItem mItem;

        ViewHolder(View view) {

            super(view);
            listItem = view;
            buttonService = view.findViewById(R.id.buttonService);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + buttonService.getText() + "'";
        }
    }
}
