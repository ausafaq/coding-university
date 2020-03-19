package Jukebox;

import java.util.Queue;

public class Playlist {
    private Song song;
    private Queue<Song> queue;

    public Playlist(Song song, Queue<Song> queue) {
        // initialize
    }

    public Song getNextSongToPlay() {
        return queue.peek();
    }

    public void queueUpSong(Song song) {
        queue.add(song);
    }
}
