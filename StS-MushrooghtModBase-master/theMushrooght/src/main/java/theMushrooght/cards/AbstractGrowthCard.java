package theMushrooght.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.Madness;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.LinkedHashMap;

public abstract class AbstractGrowthCard extends AbstractDynamicCard {
    public AbstractGrowthCard(String id, String img, int cost, CardType type, CardColor color, CardRarity rarity, CardTarget target) {
        super(id, img, cost, type, color, rarity, target);
    }

    public static LinkedHashMap<AbstractGrowthCard, Integer> weightedGrowthList;

    public static AbstractCard returnRandomGrowth() {
        if (weightedGrowthList == null) {
            weightedGrowthList = new LinkedHashMap<>();

            weightedGrowthList.put(new i6MushroomGrowth1(), 10);

            weightedGrowthList.put(new i20MushroomGrowth2(), 3);
            weightedGrowthList.put(new i21MushroomGrowth3(), 3);
            weightedGrowthList.put(new i22MushroomGrowth4(), 3);
            weightedGrowthList.put(new i23MushroomGrowth5(), 3);

            weightedGrowthList.put(new i33MushroomGrowth6(), 3);
            weightedGrowthList.put(new i34MushroomGrowth7(), 3);

            weightedGrowthList.put(new i43MushroomGrowth8(), 10);
            weightedGrowthList.put(new i44MushroomGrowth9(), 10);
            weightedGrowthList.put(new i45MushroomGrowth10(), 10);

            weightedGrowthList.put(new i55MushroomGrowth11(), 3);
            weightedGrowthList.put(new i56MushroomGrowth12(), 3);
            weightedGrowthList.put(new i57MushroomGrowth13(), 3);
            weightedGrowthList.put(new i58MushroomGrowth14(), 3);

            weightedGrowthList.put(new i67MushroomGrowth15(), 3);
            weightedGrowthList.put(new i68MushroomGrowth16(), 3);

            weightedGrowthList.put(new i71MushroomGrowth17(), 3);
            weightedGrowthList.put(new i72MushroomGrowth18(), 3);

            weightedGrowthList.put(new i77MushroomGrowth19(), 3);

            weightedGrowthList.put(new i83MushroomGrowth20(), 15);
        }

        int growthRoll = AbstractDungeon.cardRandomRng.random(1,
                weightedGrowthList.keySet().stream()
                        .mapToInt(f -> weightedGrowthList.get(f))
                        .sum()
        );

        for (AbstractGrowthCard mushy : weightedGrowthList.keySet()) {
            growthRoll -= weightedGrowthList.get(mushy);
            if (growthRoll <= 0)
                return mushy.makeCopy();
        }

        return new Madness();
    }
}