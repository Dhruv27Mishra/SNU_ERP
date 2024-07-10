import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import javax.swing.border.EmptyBorder;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


 public class SNU {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SNULINKS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);
        Color ye = new Color(192, 197, 206);

        // Create a top blue panel as a title box
        JPanel titlePanel = new JPanel(new BorderLayout());
        Color x = new Color(0, 81, 151);
        titlePanel.setBackground(x);
        titlePanel.setPreferredSize(new Dimension(frame.getWidth(), 80));
      
        // snu logo 
        ImageIcon logoIcon = loadImageIconFromURL("https://raw.githubusercontent.com/Aaradhy-Sharma/oops-gl2/main/assets-snulinks/snu-logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        titlePanel.add(logoLabel, BorderLayout.WEST);              
        Image image = logoIcon.getImage(); 
        Image newimg = image.getScaledInstance(160, 60, java.awt.Image.SCALE_SMOOTH); 
        logoIcon = new ImageIcon(newimg); 
        logoLabel = new JLabel(logoIcon);
        titlePanel.add(logoLabel, BorderLayout.WEST);
      
        // search icon
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        searchPanel.setBackground(x);
        JTextField searchBar = new JTextField(15);
        searchBar.setPreferredSize(new Dimension(30, 31));
        searchBar.setBorder(new LineBorder(ye));
        ImageIcon searchIcon = loadImageIconFromURL("https://raw.githubusercontent.com/Aaradhy-Sharma/oops-gl2/main/assets-snulinks/search-icon.png");
        JLabel searchIconLabel = new JLabel(searchIcon); // adjusting the size of the logo
        image = searchIcon.getImage(); // transform it
        newimg = image.getScaledInstance(30, 29, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        searchIcon = new ImageIcon(newimg); // transform it back
        searchIconLabel = new JLabel(searchIcon);
        searchIconLabel.setBorder(new LineBorder(ye));
        searchBar.setText(" Search");
        searchBar.setForeground(ye);
        searchBar.setMargin(new Insets(0, 0, 0, 0));
        searchPanel.add(searchIconLabel);
        searchPanel.add(searchBar);
        titlePanel.add(searchPanel, BorderLayout.CENTER);
        
        class CustomRenderer implements ListCellRenderer<String> {
            private DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        
            @Override
            public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
                if (isSelected) {
                    renderer.setBackground(new Color(128, 0, 128));
                    renderer.setForeground(Color.WHITE);
                } else {
                    renderer.setBackground(Color.WHITE);
                    renderer.setForeground(Color.BLACK);
                }
        
                if (cellHasFocus) {
                    renderer.setBackground(new Color(149, 107, 149));
                }
        
                return renderer;
            }
        }
        
        
        Font helveticaFont = new Font("Helvetica", Font.PLAIN, 14);
        String[] options = {"Logout", "Forgot Password", "Change/reset password ","IT Helpdesk", "How to Login"};
        JComboBox<String> hiNameDropdown = new JComboBox<>(options);
        hiNameDropdown.setRenderer(new CustomRenderer());
        hiNameDropdown.setBackground(x);
         hiNameDropdown.setFont(helveticaFont);
        hiNameDropdown.setForeground(Color.WHITE);
        hiNameDropdown.setVisible(false);
        
        hiNameDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String selectedOption = (String) cb.getSelectedItem();
            }
        });
        
        

        JPanel hiNamePanel = new JPanel(new BorderLayout());
        hiNamePanel.setBackground(x);
        titlePanel.add(hiNamePanel, BorderLayout.EAST);
        
        JLabel hiNameLabel = new JLabel("Hi, Dhruv Mishra ▾ ");
        hiNameLabel.setForeground(Color.WHITE);
         hiNameLabel.setFont(helveticaFont);
        
        JPopupMenu dropdownMenu = new JPopupMenu();
        
        //  arrays for URLs and corresponding names
        String[] iconUrls = { 
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/logout.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/key.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/key.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/mail.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/i.png?raw=true"
        };
        
        String[] itemNames = { 
            " Logout",
            " Forgot Password",
            " Change/reset Password",
            " IT Helpdesk",
            " How to Login"
        };
        
        for (int i = 0; i < iconUrls.length; i++) {
            ImageIcon icon = loadImageIconFromURL(iconUrls[i]); // Loading img
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(newImg);
        
            JMenuItem item = new JMenuItem(itemNames[i], scaledIcon);
            item.setBorder(new EmptyBorder(5, 5, 5, 5));
            dropdownMenu.add(item);
            
            if (i == 2) { // After the third option
                dropdownMenu.addSeparator();
            }
        }
        
        
        hiNameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dropdownMenu.show(hiNameLabel, 0, hiNameLabel.getHeight());
            }
        });
        
        hiNamePanel.add(hiNameLabel, BorderLayout.WEST);
        titlePanel.add(hiNamePanel, BorderLayout.EAST);
        

      

        // 9*6 grid layout for main panel
        JPanel buttonGrid = new JPanel(new GridLayout(9, 6, 10, 10));
        buttonGrid.setBorder(new EmptyBorder(30, 60, 20, 60)); 


        String[] logos = {
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/SNU-ERP.png?raw=true", "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Assistantship-award.png?raw=true", "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/blackboard.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/cct.png?raw=true", "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/certificate-issuance.png?raw=true","https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/course-evaluation.png?raw=true" , "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Doctoral.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/fastrack.png?raw=true", "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/HMS.png?raw=true", "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/ID-Card.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Mobile-App.png?raw=true", "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Student-Outbound01.png?raw=true", "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Student-attendance.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/OCJ.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Student-attendance.png?raw=true","https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/student-clearence.png?raw=true" , "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/student-payment-center.png?raw=true"
        };
        String[] textDepictingLogos = {
            "University ERP", "Assistantship/ Award", "Blackboard", "CCT", "Certificate Issuance", "Course Evaluation Survey", "Doctoral Portal", "Fastrack",
            "Hostel Management", "ID Card Management", "Mobile App CMS", "On Campus Job", "Student Outbound Mobility", "Student Attendance Recording", "Student Attendance Management", "Student Clearance",
            "Student Payment Center"
        };

        for (int i = 0; i < 17; i++) {
            CustomButton button;
            if (i == 0) {
                button = new CustomButton(logos[i], textDepictingLogos[i], true);
            } else {
                button = new CustomButton(logos[i], textDepictingLogos[i], false);
            }
            button.setToolTipText(textDepictingLogos[i]);
            buttonGrid.add(button);
        }

        
        

        //empty space for the remaining cells in the grid
        for (int i = 18; i <= 48; i++) {
            JPanel emptyPanel = new JPanel();
            buttonGrid.add(emptyPanel);
        }

        // array of logos for the bottom buttons
        String[] bottomButtonLogos = {
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Students-policy.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Students-handbook.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Academic&Research.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/Library.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/mes-menu.png?raw=true",
            "https://github.com/Aaradhy-Sharma/oops-gl2/blob/main/assets-snulinks/net-id.png?raw=true"
        };
        
        //array of text for bottom buttons
        String[] bottomButtonTexts = {
            " Student Policy",
            " Student Handbook",
            " Academic Research",
            " University Library",
            " Mess Menu",
            " NetID Help"
        };
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 6, 15, 20));
        Color z = new Color(23, 30, 31);
        bottomPanel.setBackground(z);
        
        class CustomBottomLabel1 extends JPanel {
            private JLabel logo;
            private JLabel textLabel;
            private String linkURL;
        
            public CustomBottomLabel1(String logoPath, String text) {
                setLayout(new BorderLayout());
                setBackground(new Color(23, 30, 31));
        
                linkURL = logoPath; // Store the URL for the hyperlink
        
                try {
                    URI uri = new URI(logoPath);
                    URL url = uri.toURL();
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream in = connection.getInputStream();
                    BufferedImage img = ImageIO.read(in);
                    if (img != null) {
                        ImageIcon originalIcon = new ImageIcon(img);
                        logo = new JLabel(originalIcon);
                        add(logo, BorderLayout.WEST);
                    } else {
                        System.out.println("Failed to load image from: " + logoPath);
                    }
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
                JSeparator separator = new JSeparator(JSeparator.VERTICAL);
                 separator.setPreferredSize(new Dimension(1, 3));
                 separator.setForeground(Color.WHITE);
                 
                // Create a clickable label for the hyperlink
                textLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;<u>" + text + "</u></html>"); // Add two non-breaking spaces before the underlined text
                textLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                textLabel.setForeground(Color.WHITE);
                textLabel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.WHITE));
                textLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(separator);
                // Open the URL in the default web browser when the label is clicked
                textLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URI(linkURL));
                        } catch (IOException | URISyntaxException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        
                add(textLabel);
            }
        }
        // Create 6 bottom labels using the arrays
        for (int i = 0; i < 6; i++) {
            CustomBottomLabel1 bottomLabel = new CustomBottomLabel1(bottomButtonLogos[i], bottomButtonTexts[i]);
            bottomLabel.setToolTipText(bottomButtonTexts[i]);
            bottomPanel.setBorder(new EmptyBorder(20, 20, 20, 10));
            bottomPanel.add(bottomLabel);

        }
         
        

        // Adding all the panels to the frame
        frame.setLayout(new BorderLayout());
        frame.add(titlePanel, BorderLayout.NORTH);
        //adding tool tip
        
        frame.add(buttonGrid, BorderLayout.CENTER);
        Color y = new Color(68,68,68);
        frame.setBackground(y);

        // Creating a panel for the bottom panels
        JPanel bottomPanels = new JPanel();
        bottomPanels.setLayout(new BoxLayout(bottomPanels, BoxLayout.Y_AXIS));
        bottomPanels.add(bottomPanel);

        JSeparator separator1 = new JSeparator();
        separator1.setForeground(new Color(134,142,150));
        separator1.setBackground(z);
        separator1.setPreferredSize(new Dimension(0, 1));
        bottomPanels.add(separator1);
        //making it very thin 
        

        // Create an extra black panel at the bottom with text in the center
        JPanel extraBottomPanel = new JPanel(new GridLayout(2, 2, 8, 10));
        extraBottomPanel.setBackground(z);
        // adding some padding
        extraBottomPanel.setBorder(new EmptyBorder(30, 10, 0, 10));
        // underlining the text
        JLabel extraBottomText = new JLabel("<html><u><span style='text-decoration:none'>© 2023 - </span>Shiv Nadar (Institution of Eminence Deemed to be University).</u></html>");

        extraBottomText.setForeground(Color.WHITE);
        extraBottomText.setHorizontalAlignment(SwingConstants.CENTER);
        extraBottomText.setVerticalAlignment(SwingConstants.CENTER);
        extraBottomPanel.add(extraBottomText);

    // Add the extra bottom panel to the bottom panels panel
         bottomPanels.add(extraBottomPanel);
        frame.add(bottomPanels, BorderLayout.SOUTH);
        frame.setVisible(true);

    }

    // Method to load an image from a URL
    private static ImageIcon loadImageIconFromURL(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage img = ImageIO.read(url);
            if (img != null) {
                return new ImageIcon(img);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

// Custom class for the bottom labels
class CustomButton extends JPanel {
    private JLabel logo;
    protected JLabel textLabel;
    private Color buttonBackground; // Store the background color
    private boolean buttonTextWhite; // Indicates whether the button text should be white
    private Color defaultBackground; // Store the default background color

    public CustomButton(String logoPath, String text, boolean isFirstButton) {
        setLayout(new BorderLayout());
        defaultBackground = isFirstButton ? new Color(11, 83, 148) : Color.WHITE;
        setBackground(defaultBackground);

        if (isFirstButton) {
            setBackground(new Color(1, 103, 189)); // Set background color to match the navbar
        } else {
            setBackground(Color.WHITE); // Set background color to white for other buttons
        }

        setBorder(new LineBorder(new Color(1, 103, 189), 1));

        try {
            URI uri = new URI(logoPath);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = connection.getInputStream();
            BufferedImage img = ImageIO.read(in);
            if (img != null) {
                logo = new JLabel(new ImageIcon(img));
                add(logo, BorderLayout.WEST);
            } else {
                System.out.println("Failed to load image from: " + logoPath);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        textLabel = new JLabel(text);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        
        if (isFirstButton) {
            textLabel.setForeground(Color.WHITE); // Set text color to white for the first button
        }

        //panel to hold the text label and the separator
        JPanel textPanel = new JPanel(new BorderLayout());
        if (isFirstButton) {
            textPanel.setBackground(new Color(1, 103, 189));
        } else {
            textPanel.setBackground(Color.WHITE);
        }
        add(textPanel, BorderLayout.CENTER);
        textPanel.add(textLabel, BorderLayout.CENTER);

        // outer panel for the separator with space at the top and bottom
        JPanel separatorPanel = new JPanel(new BorderLayout());
        if (isFirstButton) {
            separatorPanel.setBackground(new Color(0, 81, 151));
        } else {
            separatorPanel.setBackground(Color.WHITE);
        }
        separatorPanel.setPreferredSize(new Dimension(10, getHeight()));
        textPanel.add(separatorPanel, BorderLayout.WEST);

        //  blue separator line added to the separator panel
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new Dimension(5, getHeight() - 40)); 
        if (isFirstButton) {
            separator.setForeground(Color.WHITE); // separator color - white
        } else {
            separator.setForeground(Color.BLACK); //separator color - blue
        }
        separatorPanel.add(separator, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (isFirstButton) {
                    setBackground(new Color(11, 92, 155));
                    textPanel.setBackground(new Color(11, 92, 155));
                    separator.setForeground(Color.WHITE);
                    textLabel.setBackground(new Color(11, 92, 155));
                    setBorder(new LineBorder(new Color(11, 92, 155), 1));
                } else {
                    setBackground(new Color(240, 240, 240));
                    textPanel.setBackground(new Color(240, 240, 240));
                    separator.setBackground(new Color(240, 240, 240));
                    textLabel.setForeground(Color.BLACK);
                    setBorder(new LineBorder(new Color(11, 83, 148), 1));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isFirstButton) {
                    setBackground(new Color(11, 83, 148));
                    textPanel.setBackground(new Color(11, 83, 148));
                    separator.setForeground(Color.WHITE);
                    textLabel.setForeground(Color.WHITE);
                    setBorder(new LineBorder(new Color(11, 83, 148), 1));
                } else {
                    setBackground(defaultBackground);
                    textPanel.setBackground(defaultBackground);
                    separator.setForeground(new Color(0, 81, 151));
                    textLabel.setForeground(Color.BLACK);
                    setBorder(new LineBorder(new Color(0, 81, 151), 1));
                }
            }
        });

    }

    public void setButtonBackground(Color background) {
        this.buttonBackground = background;
        setBackground(background);
    }

    public void setButtonTextWhite() {
        this.buttonTextWhite = true;
        if (textLabel != null) {
            textLabel.setForeground(Color.WHITE);
        }
    }
}

class CustomBottomLabel extends JPanel {
    private JLabel logo;
    private JLabel textLabel;

    public CustomBottomLabel(String logoPath, String text) {
        setLayout(new BorderLayout());
        setBackground(new Color(23, 30, 31));

        Font font = new Font("Helvetica Neue Light", Font.PLAIN, 12);
        setFont(font);


        try {
            URI uri = new URI(logoPath);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = connection.getInputStream();
            BufferedImage img = ImageIO.read(in);
            if (img != null) {
                ImageIcon originalIcon = new ImageIcon(img);
                Image image = originalIcon.getImage();
                ImageIcon modifiedIcon = new ImageIcon(addBorderToImage(image, 0, 0, 0, 1, Color.WHITE)); 
                logo = new JLabel(modifiedIcon);
                add(logo, BorderLayout.WEST);
            } else {
                System.out.println("Failed to load image from: " + logoPath);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        textLabel = new JLabel( "<html><u>" + text + "</u></html>"); 
        textLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        textLabel.setForeground(Color.WHITE);
        textLabel.setBorder(new EmptyBorder(0,10,0,0));
        add(textLabel, BorderLayout.CENTER);
        textLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Label Pressed: " + text);
            }
        });

    }
 
   public BufferedImage addBorderToImage(Image image, int top, int left, int bottom, int right, Color borderColor) {
    int w = image.getWidth(null);
    int h = image.getHeight(null);
    BufferedImage newImage = new BufferedImage(w + left + right, h + top + bottom, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = newImage.createGraphics();
    g2.setPaint(borderColor);
    g2.fillRect(w + left, top, right, h); // Adjusted the fillRect parameters to add the border to the right
    g2.drawImage(image, left, top, null);
    g2.dispose();
    return newImage;
}
}

