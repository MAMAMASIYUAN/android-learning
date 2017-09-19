package com.example.masi6f.restauantlist.dummy;

import android.graphics.Bitmap;

import com.example.masi6f.restauantlist.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.masi6f.restauantlist.dummy.DummyContent.RestaurantList.Type.BaiCaI;
import static com.example.masi6f.restauantlist.dummy.DummyContent.RestaurantList.Type.BeiCai;
import static com.example.masi6f.restauantlist.dummy.DummyContent.RestaurantList.Type.ChuanCai;
import static com.example.masi6f.restauantlist.dummy.DummyContent.RestaurantList.Type.YueCai;

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
//    public static final List<RestaurantList> RESTAURANTS = new ArrayList<RestaurantList>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, RestaurantList> RESTAURANTS_MAP = new HashMap<String, RestaurantList>();

//    private static final int COUNT = 25;

    static {
        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
            addList(createRestaurantList());
//        }

    }

    private static void addList(RestaurantList List) {
//        RESTAURANTS.add();
        RESTAURANTS_MAP.put(List.id, List);
    }

    private static RestaurantList createRestaurantList() {
        return new RestaurantList(RestaurantList.type, RestaurantList.id, RestaurantList.content, RestaurantList.details);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about List: ").append(position);
//        for (int i = 0; i < position; i++) {
            builder.append(RestaurantList.details);
//        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class RestaurantList {


        public Bitmap image;



        public RestaurantList(Type type, String id, String content, String details) {

        }

        enum Type {ChuanCai, YueCai, BeiCai, BaiCaI}
        static Type type;
        public static String id;
        public static String content;
        public static String details;

        public RestaurantList(String id, Type type, String content, String details) {
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

    public static int getIconResource(RestaurantList.Type type){
        switch (type){
            case ChuanCai:
                return R.drawable.red;
            case YueCai:
                return R.drawable.rose;
            case BeiCai:
                return  R.drawable.sparkling;
            case BaiCaI:
                return R.drawable.white;

        }
        return -1;

    }

    public static final RestaurantList[] RESTAURANTS = {
      new RestaurantList(
              "Rest1",
              RestaurantList.Type.BaiCaI,
              "baicaidebai",
              "dabaicaixiaobaicaidoushibaicai"
      ),
      new RestaurantList(
               "Rest1",
                ChuanCai,
                "baicaidebai",
                "dabaicaixiaobaicaidoushibaicai"
            ),
      new RestaurantList(
                  "Rest1",
                  RestaurantList.Type.YueCai,
                  "baicaidebai",
                  "dabaicaixiaobaicaidoushibaicai"
            ),
            new RestaurantList(
                  "Rest1",
                  RestaurantList.Type.BeiCai,
                  "baicaidebai",
                  "dabaicaixiaobaicaidoushibaicai"
            ),

    };



}
