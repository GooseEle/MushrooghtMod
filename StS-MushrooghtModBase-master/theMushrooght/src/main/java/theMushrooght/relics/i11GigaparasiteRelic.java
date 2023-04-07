package theMushrooght.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import theMushrooght.util.TextureLoader;

import static theMushrooght.MushrooghtMod.makeRelicOutlinePath;
import static theMushrooght.MushrooghtMod.makeRelicPath;

public class i11GigaparasiteRelic extends CustomRelic {
    public static final String ID = theMushrooght.MushrooghtMod.makeID("i11GigaparasiteRelic");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("i11GigaparasiteRelic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("i11GigaparasiteRelic.png"));

    public i11GigaparasiteRelic() {
        super(ID, IMG, OUTLINE, RelicTier.SHOP, LandingSound.HEAVY);
    }
    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

}
