package ndk.banee.clickonce;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

class ServiceList {

    static final List<ServiceItem> serviceList = new ArrayList<>();

    static {

        serviceList.add(new ServiceItem("GST Registration"));
        serviceList.add(new ServiceItem("GST Filing"));
        serviceList.add(new ServiceItem("Income Tax Filing"));
        serviceList.add(new ServiceItem("Company Registration"));
        serviceList.add(new ServiceItem("LLP Registration"));
        serviceList.add(new ServiceItem("Project Report"));
        serviceList.add(new ServiceItem("Trademark"));
        serviceList.add(new ServiceItem("Partnership Deed"));
        serviceList.add(new ServiceItem("Import Export Code"));
        serviceList.add(new ServiceItem("FSSAI Registration"));
        serviceList.add(new ServiceItem("Trust Registration"));
        serviceList.add(new ServiceItem("Udhyog Aadhar"));
    }

    public static class ServiceItem {

        final String name;

        ServiceItem(String name) {

            this.name = name;
        }

        @NonNull
        @Override
        public String toString() {
            return name;
        }
    }
}
