package audioCore;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import net.dv8tion.jda.core.audio.AudioSendHandler;

/**
 * Created by zekro on 18.06.2017 / 11:45 supremeBot.audioCore dev.zekro.de -
 * github.zekro.de © zekro 2017
 */

public class PlayerSendHandler implements AudioSendHandler {

	private final AudioPlayer audioPlayer;
	private AudioFrame lastFrame;

	public PlayerSendHandler(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
	}

	@Override
	public boolean canProvide() {
		if (lastFrame == null) {
			lastFrame = audioPlayer.provide();
		}

		return lastFrame != null;
	}

	@Override
	public byte[] provide20MsAudio() {
		if (lastFrame == null) {
			lastFrame = audioPlayer.provide();
		}

		byte[] data = lastFrame != null ? lastFrame.data : null;
		lastFrame = null;

		return data;
	}

	@Override
	public boolean isOpus() {
		return true;
	}

}
