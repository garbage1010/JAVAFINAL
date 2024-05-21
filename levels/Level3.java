package levels;

// Constructor
    public Level3() {
        // Initialize the TextFileReader
        reader = new TextFileReader("levels/images/lv3dialogue.txt", 0, 600, 800, 200);

        // Setting frame properties
        setTitle("Level 3");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Creating and setting a background image
        bgimg = new JLabel();
        bgimg.setBounds(0, 0, 800, 800);
        updateBackground();

        // Adding action listener to the reader button
        reader.getButton().addActionListener(e -> {
            index++;
            if (index % 10 == 0) { //change bg event 10 lines of text. ill add fluff so that this works
                updateBackground();
            }
            if (index == 5) { // Activate the timing mini game during the fifth frame
                new TimingGame();
            }
        });

        // Creating the textbox button
        ImageIcon textboxthingy = new ImageIcon("textbox.png");
        JButton textbox = new JButton();
        textbox.setIcon(textboxthingy);
        textbox.setBounds(0, 500, 200, 100);
        textbox.addActionListener(e -> System.out.println("click"));

        // Adding components to the frame
        add(bgimg);
        add(reader.getButton());
        add(textbox);

        // Ensuring background image is on the bottom layer
        getContentPane().setComponentZOrder(bgimg, getContentPane().getComponentCount() - 1);

        setVisible(true);
    }

    // Method to update the background image
    private void updateBackground() {
        ImageIcon newBackground = new ImageIcon(bgImages[index % bgImages.length]);
        bgimg.setIcon(newBackground);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events if needed
    }

    public static void main(String[] args) {
        new Level3();
    }
}
