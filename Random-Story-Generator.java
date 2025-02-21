import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StoryGenerator {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Random Story Generator");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the text area to display the story
        JTextArea storyArea = new JTextArea();
        storyArea.setLineWrap(true); //it wraps the text, prevents overflowing
        storyArea.setWrapStyleWord(true); //Ensures whole words move to the next line instead of cutting them in half.
        storyArea.setEditable(false);
        storyArea.setFont(new Font("Arial", Font.BOLD, 20));

        // Create a scroll pane for the text area
        JScrollPane scrollPane = new JScrollPane(storyArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create the Generate button
        JButton generateButton = new JButton("Generate!");
        generateButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Define story templates
        String[] templates = {
            "One bright morning, [character] walked through [place], feeling lost and unsure about their future. As they wandered, they found [object] hidden under a tree. A note attached to it read: 'Believe in yourself, and great things will happen.'",
            "In the middle of [place], [character] found an old book lying on a bench. Inside, there was a message: 'Kindness will always find its way back to you.' Inspired, [character] decided to help a stranger that day.",
            "[character] had always been afraid to try new things. But one day, while exploring [place], they found [object] with an inscription: 'Courage is not the absence of fear, but the decision to move forward despite it.'",
            "During a festival in [place], [character] won a small, old-looking box. Inside was [object] and a letter that said: 'True happiness comes from sharing.' That day, [character] shared their prize with a friend in need.",
            "While walking through [place], [character] found a small, injured bird next to [object]. They decided to take care of the bird, feeding it and keeping it safe. After some time, the bird healed and flew away happily."
        };

        String[] characters = {"Alice", "Bob", "Charlie", "Diana"};
        String[] places = {"forest", "castle", "city", "desert"};
        String[] objects = {"a magical key", "a talking key", "a treasure map", "a golden sword"};

        Random random = new Random();

        // Add action listener to the button
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String template = templates[random.nextInt(templates.length)];
                String place = places[random.nextInt(places.length)];
                String character = characters[random.nextInt(characters.length)];
                String object = objects[random.nextInt(objects.length)];

                String story = template.replace("[character]", character)
                                       .replace("[place]", place)
                                       .replace("[object]", object);

                storyArea.setText(story);
            }
        });

        // Add the button to the frame
        frame.add(generateButton, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
} 
