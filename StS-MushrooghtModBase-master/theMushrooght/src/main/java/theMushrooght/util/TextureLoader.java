package theMushrooght.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.util.HashMap;

public class TextureLoader {
    private static HashMap<String, Texture> textures = new HashMap<String, Texture>();

    public static Texture getTexture(final String textureString) {
        if (textures.get(textureString) == null) {
            try {
                loadTexture(textureString);
            } catch (GdxRuntimeException e) {
                System.out.println("Could not find texture: " + textureString);
                return getTexture("theMushrooghtResources/images/ui/missing_texture.png");
            }
        }
        return textures.get(textureString);
    }
    private static void loadTexture(final String textureString) throws GdxRuntimeException {
        System.out.println("MushrooghtMod | Loading Texture: " + textureString);
        Texture texture = new Texture(textureString);
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        textures.put(textureString, texture);
    }
}
