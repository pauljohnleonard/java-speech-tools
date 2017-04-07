/* Generated by TooT */

package uk.org.toot.swingui.midiui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//import uk.org.toot.midi.transport.MidiChannel;
import uk.org.toot.midi.misc.GM;

public class GMDrumPopup extends JPopupMenu
{
//    private MidiChannel channel;

    public GMDrumPopup() {
        super("General MIDI Program");
        setup();
    }


    protected void setup() {
        for ( int f = 0 ; f < GM.drumFamilyCount() ; f++ ) {
            String familyName = GM.drumFamilyName(f);
            JMenu menu = new JMenu(familyName);
//            menu.setBackground(MidiColor.getBackground(familyName));
			int[] drums = GM.drumFamily(f);
            for ( int d = 0; d < drums.length; d++ ) {
                int drum = drums[d];
                menu.add(new DrumItem(drum));
            }
            add(menu);
        }
    }

    protected void setDrum(int drum) {
    }

/*    public void setChannel(MidiChannel channel) {
		this.channel = channel;
    } */

    protected class DrumItem extends JMenuItem implements ActionListener
    {
        private int drum = 0;

        public DrumItem(int drum) {
			super(GM.drumName(drum));
//            setBackground(MidiColor.getBackground(prg));
            this.drum = drum;
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            GMDrumPopup.this.setDrum(this.drum);
//            channel.programChange(prg);
        }
    }
}