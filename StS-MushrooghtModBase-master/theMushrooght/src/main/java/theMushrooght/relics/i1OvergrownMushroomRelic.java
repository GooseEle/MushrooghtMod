package theMushrooght.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import theMushrooght.util.TextureLoader;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static theMushrooght.MushrooghtMod.makeRelicOutlinePath;
import static theMushrooght.MushrooghtMod.makeRelicPath;

public class i1OvergrownMushroomRelic extends CustomRelic {

    public static final String ID = theMushrooght.MushrooghtMod.makeID("i1OvergrownMushroomRelic");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("i1OvergrownMushroomRelic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("i1OvergrownMushroomRelic.png"));
    private boolean firstTurn;

    public i1OvergrownMushroomRelic() {
        super(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.FLAT);
    }
    // Gain 1 energy on equip.

    public void onPlayerEndTurn() {
            addToBot(new ReducePowerAction(player, player, "Weakened", 1));
            addToBot(new ReducePowerAction(player, player, "Frail", 1));
            addToBot(new ReducePowerAction(player, player, "Vulnerable", 1));
    }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
