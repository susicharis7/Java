package Design_Patterns.Adapter;

interface OldMediaPlayer {
    void playOldFormat(String filename);
}

interface NewMediaPlayer {
    void playNewFormat(String filename);
}

class OldMediaPlayerImpl implements OldMediaPlayer {
    public void playOldFormat(String filename) {
        System.out.println("Playing old format...");
    }
}

class NewMediaPlayerImpl implements NewMediaPlayer {
    public void playNewFormat(String filename) {
        System.out.println("Playing new format...");
    }
}

class MediaPlayerAdapter implements NewMediaPlayer {
    private OldMediaPlayer oldMediaPlayer;

    public MediaPlayerAdapter(OldMediaPlayer oldMediaPlayer) {
        this.oldMediaPlayer = oldMediaPlayer;
    }

    public void playNewFormat(String filename) {
        this.oldMediaPlayer.playOldFormat(filename);
    }
}