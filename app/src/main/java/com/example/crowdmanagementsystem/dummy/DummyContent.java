package com.example.crowdmanagementsystem.dummy;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    public static int COUNT = 1;

        // Add some sample items.
        //addItem(createDummyItem(id, name, organizer, capacity, contactno, time, address));

    public static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static DummyItem createDummyItem(String id, String organizer, Long capacity, Long contactno, Timestamp time, String address) {
        return new DummyItem(id, organizer, capacity, contactno, time, address);
    }
/*
    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Event: ").append(position);
        return builder.toString();
    }*/

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        /*public final String id;
        public final String content;
        public final String details;*/
        public final String id;
        private String organizer;
        private Long capacity;
        private Long contactno;
        private Timestamp time;
        private String address;


        public DummyItem(String id, String organizer, Long capacity, Long contactno, Timestamp time, String address) {
            this.id = id;
            this.organizer = organizer;
            this.capacity = capacity;
            this.contactno = contactno;
            this.time = time;
            this.address = address;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Name: ").append(id);
            builder.append("\nOrganizer: ").append(organizer);
            builder.append("\nCapacity: ").append(capacity);
            builder.append("\nTime: ").append(time);
            builder.append("\nAddress: ").append(address);
            builder.append("\nContact Number: ").append(contactno);
            return builder.toString();
        }
    }
}