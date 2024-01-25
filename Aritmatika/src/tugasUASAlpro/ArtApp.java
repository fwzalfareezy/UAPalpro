package tugasUASAlpro;

import Art.ArtCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArtApp {

    private JFrame frame;
    private JTextField textFieldInput;
    private JLabel labelOutput1;
    private JLabel labelOutput2;
    private JLabel labelComparisonResult;

    private String[] options = {"Persegi", "Lingkaran"};
    private JComboBox<String> comboBoxOptions;
    private JButton btnCalculate;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ArtApp window = new ArtApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public ArtApp() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textFieldInput = new JTextField();
        textFieldInput.setBounds(41, 112, 265, 20);
        frame.getContentPane().add(textFieldInput);
        textFieldInput.setColumns(10);

        comboBoxOptions = new JComboBox<>(options);
        comboBoxOptions.setBounds(332, 111, 117, 23);
        frame.getContentPane().add(comboBoxOptions);

        btnCalculate = new JButton("Hitung");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        btnCalculate.setBounds(189, 316, 117, 23);
        frame.getContentPane().add(btnCalculate);

        labelOutput1 = new JLabel("luas");
        labelOutput1.setBounds(41, 143, 408, 14);
        frame.getContentPane().add(labelOutput1);

        labelOutput2 = new JLabel("keliling");
        labelOutput2.setBounds(41, 168, 408, 14);
        frame.getContentPane().add(labelOutput2);

        labelComparisonResult = new JLabel("Hasil Perbandingan: ");
        labelComparisonResult.setBounds(41, 193, 408, 14);
        frame.getContentPane().add(labelComparisonResult);

        JLabel labelNote = new JLabel("Masukkan Sisi untuk persegi dan radius untuk lingkaran");
        labelNote.setHorizontalAlignment(SwingConstants.CENTER);
        labelNote.setBounds(41, 291, 408, 14);
        frame.getContentPane().add(labelNote);
        
        JLabel lblOperasiLuasBangun = new JLabel("OPERASI LUAS BANGUN");
        lblOperasiLuasBangun.setFont(new Font("Tahoma", Font.PLAIN, 27));
        lblOperasiLuasBangun.setHorizontalAlignment(SwingConstants.CENTER);
        lblOperasiLuasBangun.setBounds(41, 11, 408, 33);
        frame.getContentPane().add(lblOperasiLuasBangun);
        
        JLabel lblPersegiDanLingkaran = new JLabel("Persegi dan Lingkaran");
        lblPersegiDanLingkaran.setHorizontalAlignment(SwingConstants.CENTER);
        lblPersegiDanLingkaran.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPersegiDanLingkaran.setBounds(41, 32, 408, 33);
        frame.getContentPane().add(lblPersegiDanLingkaran);
    }

    private void calculate() {
        try {
            String selectedOption = comboBoxOptions.getSelectedItem().toString();
            double input = Double.parseDouble(textFieldInput.getText());

            switch (selectedOption) {
                case "Persegi":
                    calculateSquare(input);
                    break;
                case "Lingkaran":
                    calculateCircle(input);
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e) {
            clearLabels();
        }
    }

    private void calculateSquare(double sideLength) {
        double area = ArtCalculator.calculateSquareArea(sideLength);
        double perimeter = ArtCalculator.calculateSquarePerimeter(sideLength);

        labelOutput1.setText("Luas: " + area);
        labelOutput2.setText("Keliling: " + perimeter);

        compareAreaAndPerimeter(area, perimeter);
    }

    private void calculateCircle(double radius) {
        double area = ArtCalculator.calculateCircleArea(radius);
        double perimeter = ArtCalculator.calculateCirclePerimeter(radius);

        labelOutput1.setText("Luas: " + area);
        labelOutput2.setText("Keliling: " + perimeter);

        compareAreaAndPerimeter(area, perimeter);
    }

    private void compareAreaAndPerimeter(double area, double perimeter) {
        if (ArtCalculator.isAreaGreaterThanPerimeter(area, perimeter)) {
            labelComparisonResult.setText("Hasil Perbandingan: Luas lebih besar dari Keliling");
        } else if (area < perimeter) {
            labelComparisonResult.setText("Hasil Perbandingan: Luas lebih kecil dari Keliling");
        } else {
            labelComparisonResult.setText("Hasil Perbandingan: Luas sama dengan Keliling");
        }
    }

    private void clearLabels() {
        labelOutput1.setText("Output 1: ");
        labelOutput2.setText("Output 2: ");
        labelComparisonResult.setText("Hasil Perbandingan: ");
    }
}
