package com.example.iori.restlist.dummy;

import android.renderscript.Type;

import com.example.iori.restlist.R;

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
    private static final DummyItem[] ITEMSS = {
            new DummyItem("Red Rest",
                    DummyItem.Type.Red,
                    "This Rest is Red",
                    "Rest is a red.Rest is a red.Rest is a red.Rest is a red.Rest is a red.Rest is a red.Rest is a red.Rest is a red.Rest is a red. "),

            new DummyItem("Red Rest No2",
                    DummyItem.Type.Red,
                    "This Rest is Red, too.",
                    "This Rest is Red, too.This Rest is Red, too.This Rest is Red, too.This Rest is Red, too.This Rest is Red, too.This Rest is Red, too.This Rest is Red, too.This Rest is Red, too."),

            new DummyItem("Sparkling Rest",
                    DummyItem.Type.Sparkling,
                    "This Rest is Sparkling.",
                    "This Rest is Sparkling.This Rest is Sparkling.This Rest is Sparkling.This Rest is Sparkling.This Rest is Sparkling.This Rest is Sparkling.This Rest is Sparkling.This Rest is Sparkling."),

            new DummyItem("White Rest",
                    DummyItem.Type.White,
                    "This Rest is White.",
                    "This Rest is White.This Rest is White.This Rest is White.This Rest is White.This Rest is White.This Rest is White.This Rest is White.This Rest is White.This Rest is White."),

            new DummyItem("Rose Rest",
                    DummyItem.Type.Rosé,
                    "This Rest is Rose.",
                    "This Rest is Rose.This Rest is Rose.This Rest is Rose.This Rest is Rose.This Rest is Rose.This Rest is Rose.This Rest is Rose.This Rest is Rose.This Rest is Rose.."),


    };

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

//    private static final int COUNT = 25;

    static {

        // Add some sample items.
        for (int i = 0; i < ITEMSS.length; i++) {
//            addItem(createDummyItem(i));
            ITEMS.add(ITEMSS[i]);
            ITEM_MAP.put(ITEMSS[i].getId(), ITEMSS[i]);
        }
    }

//    private static DummyItem createDummyItem(int position) {
//        return new DummyItem(makeTitle(position), makeType(position), makeShort(position), makeDetails(position));
//    }
//    private static String makeTitle(int position) {
//
//        return DummyContent.ITEMSS[position].getId();
//    }
//    private static DummyItem.Type makeType(int position) {
//        StringBuilder builder = new StringBuilder();
//
//        return DummyContent.ITEMSS[position].getType();
//    }
//
//    private static String makeShort(int position) {
//
//        return DummyContent.ITEMSS[position].getContent();
//    }
//    private static String makeDetails(int position) {
//        return DummyContent.ITEMSS[position].getDetails();
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {

        public enum Type {Red, White, Rosé, Sparkling}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
         String id;
         DummyItem.Type type;
         String content;
         String details;

        public DummyItem(String id, DummyItem.Type type, String content, String details) {
            this.id = id;
            this.type = type;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }

    }




}
