package com.adkar.salah;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends Activity {

    private final int green = Color.rgb(20, 92, 68);
    private final int cream = Color.rgb(244, 248, 244);
    private final int gold = Color.rgb(200, 163, 89);

    private final String[] titles = {
        "الاستغفار الأول",
        "الاستغفار الثاني",
        "الاستغفار الثالث",
        "دعاء السلام",
        "الذكر بعد الصلاة",
        "دعاء بعد الصلاة",
        "التسبيح",
        "التحميد",
        "التكبير",
        "خاتمة التسبيح",
        "آية الكرسي",
        "سورة الإخلاص",
        "سورة الفلق",
        "سورة الناس",
        "دعاء الاستعانة على العبادة"
    };

    private final String[] texts = {
        "أَسْتَغْفِرُ اللَّهَ.",
        "أَسْتَغْفِرُ اللَّهَ.",
        "أَسْتَغْفِرُ اللَّهَ.",

        "اللَّهُمَّ أَنْتَ السَّلَامُ وَمِنْكَ السَّلَامُ، تَبَارَكْتَ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ.",

        "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ.",

        "اللَّهُمَّ لَا مَانِعَ لِمَا أَعْطَيْتَ، وَلَا مُعْطِيَ لِمَا مَنَعْتَ، وَلَا يَنْفَعُ ذَا الْجَدِّ مِنْكَ الْجَدُّ.",

        "سُبْحَانَ اللَّهِ",

        "الْحَمْدُ لِلَّهِ",

        "اللَّهُ أَكْبَرُ",

        "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ.",

        "اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ، لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ، لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ، مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلَّا بِإِذْنِهِ، يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ، وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ، وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ، وَلَا يَئُودُهُ حِفْظُهُمَا، وَهُوَ الْعَلِيُّ الْعَظِيمُ.",

        "قُلْ هُوَ اللَّهُ أَحَدٌ ۝ اللَّهُ الصَّمَدُ ۝ لَمْ يَلِدْ وَلَمْ يُولَدْ ۝ وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ.",

        "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ ۝ مِنْ شَرِّ مَا خَلَقَ ۝ وَمِنْ شَرِّ غَاسِقٍ إِذَا وَقَبَ ۝ وَمِنْ شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ ۝ وَمِنْ شَرِّ حَاسِدٍ إِذَا حَسَدَ.",

        "قُلْ أَعُوذُ بِرَبِّ النَّاسِ ۝ مَلِكِ النَّاسِ ۝ إِلَٰهِ النَّاسِ ۝ مِنْ شَرِّ الْوَسْوَاسِ الْخَنَّاسِ ۝ الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ ۝ مِنَ الْجِنَّةِ وَالنَّاسِ.",

        "اللَّهُمَّ أَعِنِّي عَلَى ذِكْرِكَ وَشُكْرِكَ وَحُسْنِ عِبَادَتِكَ."
    };

    private final int[] goals = {
        1, 1, 1, 1, 1, 1, 33, 33, 34, 1, 1, 1, 1, 1, 1
    };

    private int[] counts;
    private TextView[] countViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // التأكد من توافق عدد الأذكار والعناوين والأهداف
        if (titles.length != texts.length ||
            goals.length != texts.length) {
            TextView error = new TextView(this);
            error.setText("حدث خطأ في بيانات الأذكار.");
            error.setGravity(Gravity.CENTER);
            setContentView(error);
            return;
        }

        counts = new int[texts.length];
        countViews = new TextView[texts.length];

        showAdhkar();
    }

    private GradientDrawable makeShape(int color, int radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(color);
        drawable.setCornerRadius(radius);
        return drawable;
    }

    private TextView makeText(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER);
        t.setPadding(14, 12, 14, 12);
        t.setTextDirection(View.TEXT_DIRECTION_RTL);
        t.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        return t;
    }

    private void showAdhkar() {
        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setBackgroundColor(cream);

        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);
        list.setPadding(14, 18, 14, 24);

        TextView header = makeText(
            "أذكار ما بعد الصلاة", 27, Color.WHITE
        );
        header.setTypeface(null, Typeface.BOLD);
        header.setBackground(makeShape(green, 20));
        list.addView(header);

        TextView subtitle = makeText(
            "اذكر الله واطمئن قلبك", 18, green
        );
        list.addView(subtitle);

        TextView reset = makeText(
            "إعادة ضبط العدّادات", 17, Color.WHITE
        );
        reset.setBackground(makeShape(green, 14));

        LinearLayout.LayoutParams resetParams =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        resetParams.setMargins(0, 8, 0, 14);
        list.addView(reset, resetParams);

        reset.setOnClickListener(v -> {
            for (int i = 0; i < counts.length; i++) {
                counts[i] = 0;
                updateCount(i);
            }
        });

        for (int i = 0; i < texts.length; i++) {
            final int index = i;

            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setPadding(12, 12, 12, 12);
            card.setBackground(makeShape(Color.WHITE, 18));

            LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                );

            cardParams.setMargins(0, 7, 0, 7);

            TextView title = makeText(
                titles[index], 19, green
            );
            title.setTypeface(null, Typeface.BOLD);
            card.addView(title);

            TextView body = makeText(
                texts[index], 22, Color.rgb(40, 48, 42)
            );
            body.setLineSpacing(8, 1.1f);
            card.addView(body);

            TextView target = makeText(
                "عدد التكرارات: " + goals[index],
                15, green
            );
            card.addView(target);

            countViews[index] = makeText(
                "تم التسبيح: 0 من " + goals[index],
                17, green
            );
            card.addView(countViews[index]);

            TextView countButton = makeText(
                "اضغط للتسجيل", 18, Color.WHITE
            );
            countButton.setBackground(makeShape(green, 14));
            card.addView(countButton);

            countButton.setOnClickListener(v -> {
                if (counts[index] < goals[index]) {
                    counts[index]++;
                    updateCount(index);
                }

                if (counts[index] == goals[index]) {
                    countViews[index].setText(
                        "اكتمل العدد: " + counts[index]
                    );
                }
            });

            list.addView(card, cardParams);
        }

        scroll.addView(list);
        setContentView(scroll);
    }

    private void updateCount(int index) {
        if (countViews != null &&
            index >= 0 &&
            index < countViews.length &&
            countViews[index] != null) {

            countViews[index].setText(
                "تم التسبيح: " + counts[index] +
                " من " + goals[index]
            );
        }
    }
}