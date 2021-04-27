package me.travis.wurstplusthree.util;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoundUtil implements Globals {
    public static final ISound sound;
    private static final List<String> songs = Arrays.asList(
            "sound",
            "sound2",
            "sound3"
    );

    private static final String song = songs.get(random.nextInt(songs.size()));
    private static final ResourceLocation loc = new ResourceLocation("sounds/" + song + ".ogg");

    static {
        sound = new ISound() {

            private final int pitch = 1;
            private final int volume = 1;

            @Override
            public ResourceLocation getSoundLocation() {
                return loc;
                //return null;
            }

            @Nullable
            @Override
            public SoundEventAccessor createAccessor(SoundHandler soundHandler) {
                return new SoundEventAccessor(loc, "Pitbull");
            }

            @Override
            public Sound getSound() {
                return new Sound(song, volume, pitch, 1, Sound.Type.SOUND_EVENT, false);
            }

            @Override
            public SoundCategory getCategory() {
                return SoundCategory.VOICE;
            }

            @Override
            public boolean canRepeat() {
                return true;
            }

            @Override
            public int getRepeatDelay() {
                return 2;
            }

            @Override
            public float getVolume() {
                return volume;
            }

            @Override
            public float getPitch() {
                return pitch;
            }

            @Override
            public float getXPosF() {
                return 1;
            }

            @Override
            public float getYPosF() {
                return 0;
            }

            @Override
            public float getZPosF() {
                return 0;
            }

            @Override
            public AttenuationType getAttenuationType() {
                return AttenuationType.LINEAR;
            }
        };
    }
}

