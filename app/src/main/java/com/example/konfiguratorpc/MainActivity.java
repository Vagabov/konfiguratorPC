package com.example.konfiguratorpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.konfiguratorpc.LoginActivity;
import com.example.konfiguratorpc.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser user;
    Spinner processorSpinner;
    Spinner motherboardSpinner;
    Spinner ramSpinner;
    TextView totalPriceTextView;
    double totalPrice;
    Spinner graphicsCardSpinner;
    Spinner ssdSpinner;
    Spinner Cooling;
    Spinner powerSupplySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        mAuth = FirebaseAuth.getInstance();
        processorSpinner = findViewById(R.id.processor_spinner);
        motherboardSpinner = findViewById(R.id.motherboard_spinner);
        ramSpinner = findViewById(R.id.ram_spinner);
        totalPriceTextView = findViewById(R.id.total_price_text);
        graphicsCardSpinner = findViewById(R.id.graphics_card_spinner);
        ssdSpinner = findViewById(R.id.ssd_spinner);
        Cooling = findViewById(R.id.cooling);
        powerSupplySpinner = findViewById(R.id.powerSupplySpinner);


        List<Processor> processors = new ArrayList<>();
        processors.add(new Processor("Intel Core i3-10100f", 5499.0));
        processors.add(new Processor("Intel Core i3-12100f", 8299.0));
        processors.add(new Processor("Intel Core i5-10400f", 8899.0));
        processors.add(new Processor("Intel Core i5-11400f", 9999.0));
        processors.add(new Processor("Intel Core i5-12400f", 14999.0));
        processors.add(new Processor("Intel Core i7-10700f", 17499.0));
        processors.add(new Processor("Intel Core i7-11700f", 20999.0));
        processors.add(new Processor("Intel Core i7-12700f", 22999.0));
        processors.add(new Processor("Intel Core i9-10900f", 28999.0));
        processors.add(new Processor("Intel Core i9-11900f", 29999.0));
        processors.add(new Processor("Intel Core i9-12900f", 32999.0));
        processors.add(new Processor("AMD Ryzen 5 3600", 7899.0));
        processors.add(new Processor("AMD Ryzen 5 5500", 8899.0));
        processors.add(new Processor("AMD Ryzen 5 5600x", 13399.0));
        processors.add(new Processor("AMD Ryzen 7 5700x", 20399.0));
        processors.add(new Processor("AMD Ryzen 7 5800x", 20899.0));
        processors.add(new Processor("AMD Ryzen 7 5800x3D", 29799.0));
        processors.add(new Processor("AMD Ryzen 9 5900x", 28499.0));
        processors.add(new Processor("AMD Ryzen 9 5950x", 33999.0));
        processors.add(new Processor("AMD Ryzen 9 7900x", 37499.0));
        processors.add(new Processor("AMD Ryzen 9 7950x", 51799.0));

        ArrayAdapter<Processor> processorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, processors);
        processorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        processorSpinner.setAdapter(processorAdapter);

        List<Motherboard> motherboards = new ArrayList<>();
        motherboards.add(new Motherboard("MSI H510M-A PRO", 6099.0));
        motherboards.add(new Motherboard("GIGABYTE B560M DS3H V2", 7899.0));
        motherboards.add(new Motherboard("GIGABYTE B660 GAMING X DDR4", 12299.0));
        motherboards.add(new Motherboard("GIGABYTE B660M DS3H DDR4", 8899.0));
        motherboards.add(new Motherboard("GIGABYTE Z790 AORUS ELITE AX", 23999.0));
        motherboards.add(new Motherboard("GIGABYTE B550 AORUS ELITE V2", 11999.0));
        motherboards.add(new Motherboard("GIGABYTE B550M AORUS ELITE", 9399.0));
        motherboards.add(new Motherboard("MSI MAG B550 TOMAHAWK", 13799.0));
        motherboards.add(new Motherboard("GIGABYTE B650 AORUS ELITE AX", 20499.0));
        motherboards.add(new Motherboard("GIGABYTE X670E AORUS MASTER", 43499.0));


        ArrayAdapter<Motherboard> motherboardAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, motherboards);
        motherboardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        motherboardSpinner.setAdapter(motherboardAdapter);

        List<RAM> rams = new ArrayList<>();
        rams.add(new RAM("Kingston FURY Beast Black 16 ГБ", 4399.0));
        rams.add(new RAM("Kingston FURY Beast Black 32 ГБ", 7799.0));
        rams.add(new RAM("ADATA XPG SPECTRIX D41 RGB 16 ГБ", 3899.0));
        rams.add(new RAM("ADATA XPG SPECTRIX D50 RGB 16 ГБ", 3999.0));
        rams.add(new RAM("Kingston FURY Renegade RGB 32 ГБ", 9799.0));
        rams.add(new RAM("G.Skill RIPJAWS V 32 ГБ", 6699.0));
        rams.add(new RAM("Patriot Viper Steel 64 ГБ", 13399.0));
        rams.add(new RAM("Patriot Viper Elite II 64 ГБ", 12999.0));

        ArrayAdapter<RAM> ramAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, rams);
        ramAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ramSpinner.setAdapter(ramAdapter);

        List<GraphicsCard> graphicsCards = new ArrayList<>();
        graphicsCards.add(new GraphicsCard("NVIDIA GeForce GTX 1650", 9999.0));
        graphicsCards.add(new GraphicsCard("NVIDIA GeForce GTX 1660", 14999.0));
        graphicsCards.add(new GraphicsCard("NVIDIA GeForce RTX 2060", 19999.0));
        graphicsCards.add(new GraphicsCard("NVIDIA GeForce RTX 3060", 24999.0));
        graphicsCards.add(new GraphicsCard("NVIDIA GeForce RTX 3070", 34999.0));
        graphicsCards.add(new GraphicsCard("NVIDIA GeForce RTX 3080", 44999.0));
        graphicsCards.add(new GraphicsCard("NVIDIA GeForce RTX 3090", 59999.0));
        graphicsCards.add(new GraphicsCard("NVIDIA GeForce RTX 4080 GameRock OmniBlack ", 105499.0));
        graphicsCards.add(new GraphicsCard("NVIDIA GeForce RTX 4090 SUPRIM X", 180999.0));
        graphicsCards.add(new GraphicsCard("AMD Radeon RX 550", 6999.0));
        graphicsCards.add(new GraphicsCard("AMD Radeon RX 560", 8999.0));
        graphicsCards.add(new GraphicsCard("AMD Radeon RX 570", 10999.0));
        graphicsCards.add(new GraphicsCard("AMD Radeon RX 580", 12999.0));
        graphicsCards.add(new GraphicsCard("AMD Radeon RX 6700 XT", 24999.0));
        graphicsCards.add(new GraphicsCard("AMD Radeon RX 6800", 29999.0));
        graphicsCards.add(new GraphicsCard("AMD Radeon RX 6900 XT", 39999.0));

        ArrayAdapter<GraphicsCard> graphicsCardAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, graphicsCards);
        graphicsCardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graphicsCardSpinner.setAdapter(graphicsCardAdapter);

        List<SSD> ssds = new ArrayList<>();
        ssds.add(new SSD("1000 ГБ SSD M.2 Samsung 980", 8699.0));
        ssds.add(new SSD("1000 ГБ SSD M.2 Samsung 980 PRO", 12499.0));
        ssds.add(new SSD("500 ГБ SSD M.2 Samsung 970 EVO Plus", 5599.0));
        ssds.add(new SSD("1000 ГБ SSD M.2 Samsung 970 EVO Plus ", 9299.0));
        ssds.add(new SSD("1000 ГБ SSD M.2 Kingston FURY Renegade", 10699.0));
        ssds.add(new SSD("1000 ГБ SSD M.2 ADATA GAMMIX S11 Pro", 7299.0));
        ssds.add(new SSD("512 ГБ SSD M.2 Kingston KC3000", 4999.0));
        ssds.add(new SSD("500 ГБ SSD M.2 Kingston NV2", 4299.0));
        ssds.add(new SSD("250 ГБ SSD M.2 Samsung 980", 3099.0));

        ArrayAdapter<SSD> ssdAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ssds);
        ssdAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ssdSpinner.setAdapter(ssdAdapter);

        List<Cooling> coolings = new ArrayList<>();
        coolings.add(new Cooling("Кулер be quiet! DARK ROCK PRO 4", 10499.0));
        coolings.add(new Cooling("Кулер DEEPCOOL GAMMAXX 300", 1599.0));
        coolings.add(new Cooling("Кулер DEEPCOOL AK620", 5799.0));
        coolings.add(new Cooling("Кулер DEEPCOOL AK620 ZERO DARK", 5699.0));
        coolings.add(new Cooling("Кулер DEEPCOOL AG400 BK ARGB", 2799.0));
        coolings.add(new Cooling("Кулер Noctua NH-U12S", 12299.0));
        coolings.add(new Cooling("Кулер DEEPCOOL AK400", 2550.0));
        coolings.add(new Cooling("Кулер DEEPCOOL GAMMAXX AG620 BK ARGB", 5099.0));
        coolings.add(new Cooling("Система охлаждения DEEPCOOL LS720", 11999.0));
        coolings.add(new Cooling("Система охлаждения DeepCool LT720", 10499.0));
        coolings.add(new Cooling("Система охлаждения LIAN LI Galahad SL Edition 360", 16799.0));
        coolings.add(new Cooling("Система охлаждения DEEPCOOL LS720 WH", 11699.0));
        coolings.add(new Cooling("Система охлаждения DEEPCOOL LS520", 9999.0));

        ArrayAdapter<Cooling> coolingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, coolings);
        coolingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Cooling.setAdapter(coolingAdapter);

        List<PowerSupply> powerSupplies = new ArrayList<>();
        powerSupplies.add(new PowerSupply("Cooler Master MWE Bronze 450W", 2999.0));
        powerSupplies.add(new PowerSupply("EVGA 600 W1, 80+ WHITE 600W", 3299.0));
        powerSupplies.add(new PowerSupply("Corsair CV550, CV Series, 80 PLUS Bronze", 3999.0));
        powerSupplies.add(new PowerSupply("Cooler Master MWE Gold 750W", 6599.0));
        powerSupplies.add(new PowerSupply("Corsair RMx Series RM750x", 6999.0));
        powerSupplies.add(new PowerSupply("EVGA SuperNOVA 850 T2, 80+ TITANIUM 850W", 12299.0));
        powerSupplies.add(new PowerSupply("DEEPCOOL PQ850M", 11099.0));

        ArrayAdapter<PowerSupply> powerSupplyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, powerSupplies);
        powerSupplyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        powerSupplySpinner.setAdapter(powerSupplyAdapter);

        processorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Processor selectedProcessor = (Processor) processorSpinner.getSelectedItem();
                double processorPrice = selectedProcessor.getPrice();
                double motherboardPrice = ((Motherboard) motherboardSpinner.getSelectedItem()).getPrice();
                double ramPrice = ((RAM) ramSpinner.getSelectedItem()).getPrice();

                totalPrice = processorPrice + motherboardPrice + ramPrice;
                totalPriceTextView.setText(String.valueOf(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle if nothing is selected
            }
        });

        motherboardSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Processor selectedProcessor = (Processor) processorSpinner.getSelectedItem();
                double processorPrice = selectedProcessor.getPrice();

                Motherboard selectedMotherboard = (Motherboard) motherboardSpinner.getSelectedItem();
                double motherboardPrice = selectedMotherboard.getPrice();
                double ramPrice = ((RAM) ramSpinner.getSelectedItem()).getPrice();

                totalPrice = processorPrice + motherboardPrice + ramPrice;
                totalPriceTextView.setText(String.valueOf(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle if nothing is selected
            }
        });

        ramSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Processor selectedProcessor = (Processor) processorSpinner.getSelectedItem();
                double processorPrice = selectedProcessor.getPrice();

                Motherboard selectedMotherboard = (Motherboard) motherboardSpinner.getSelectedItem();
                double motherboardPrice = selectedMotherboard.getPrice();

                RAM selectedRam = (RAM) ramSpinner.getSelectedItem();
                double ramPrice = selectedRam.getPrice();

                totalPrice = processorPrice + motherboardPrice + ramPrice;
                totalPriceTextView.setText(String.valueOf(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle if nothing is selected
            }
        });
        graphicsCardSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Processor selectedProcessor = (Processor) processorSpinner.getSelectedItem();
                double processorPrice = selectedProcessor.getPrice();

                Motherboard selectedMotherboard = (Motherboard) motherboardSpinner.getSelectedItem();
                double motherboardPrice = selectedMotherboard.getPrice();

                RAM selectedRam = (RAM) ramSpinner.getSelectedItem();
                double ramPrice = selectedRam.getPrice();

                GraphicsCard selectedGraphicsCard = (GraphicsCard) graphicsCardSpinner.getSelectedItem();
                double graphicsCardPrice = selectedGraphicsCard.getPrice();

                totalPrice = processorPrice + motherboardPrice + ramPrice + graphicsCardPrice;
                totalPriceTextView.setText(String.valueOf(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Обработайте случай, если ничего не выбрано
            }
        });
        ssdSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Processor selectedProcessor = (Processor) processorSpinner.getSelectedItem();
                double processorPrice = selectedProcessor.getPrice();

                Motherboard selectedMotherboard = (Motherboard) motherboardSpinner.getSelectedItem();
                double motherboardPrice = selectedMotherboard.getPrice();

                RAM selectedRam = (RAM) ramSpinner.getSelectedItem();
                double ramPrice = selectedRam.getPrice();

                GraphicsCard selectedGraphicsCard = (GraphicsCard) graphicsCardSpinner.getSelectedItem();
                double graphicsCardPrice = selectedGraphicsCard.getPrice();

                SSD selectedSSD = (SSD) ssdSpinner.getSelectedItem();
                double ssdPrice = selectedSSD.getPrice();

                totalPrice = processorPrice + motherboardPrice + ramPrice + graphicsCardPrice + ssdPrice;
                totalPriceTextView.setText(String.valueOf(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Обработайте случай, если ничего не выбрано
            }

        });
        Cooling.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Processor selectedProcessor = (Processor) processorSpinner.getSelectedItem();
                double processorPrice = selectedProcessor.getPrice();

                Motherboard selectedMotherboard = (Motherboard) motherboardSpinner.getSelectedItem();
                double motherboardPrice = selectedMotherboard.getPrice();

                RAM selectedRam = (RAM) ramSpinner.getSelectedItem();
                double ramPrice = selectedRam.getPrice();

                GraphicsCard selectedGraphicsCard = (GraphicsCard) graphicsCardSpinner.getSelectedItem();
                double graphicsCardPrice = selectedGraphicsCard.getPrice();

                SSD selectedSSD = (SSD) ssdSpinner.getSelectedItem();
                double ssdPrice = selectedSSD.getPrice();

                Cooling selectedCooling = (Cooling) parent.getSelectedItem();
                double coolingPrice = selectedCooling.getPrice();

                totalPrice = processorPrice + motherboardPrice + ramPrice + graphicsCardPrice + ssdPrice + coolingPrice;
                totalPriceTextView.setText(String.valueOf(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No action needed
            }
        });
        powerSupplySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Processor selectedProcessor = (Processor) processorSpinner.getSelectedItem();
                double processorPrice = selectedProcessor.getPrice();

                Motherboard selectedMotherboard = (Motherboard) motherboardSpinner.getSelectedItem();
                double motherboardPrice = selectedMotherboard.getPrice();

                RAM selectedRam = (RAM) ramSpinner.getSelectedItem();
                double ramPrice = selectedRam.getPrice();

                GraphicsCard selectedGraphicsCard = (GraphicsCard) graphicsCardSpinner.getSelectedItem();
                double graphicsCardPrice = selectedGraphicsCard.getPrice();

                SSD selectedSSD = (SSD) ssdSpinner.getSelectedItem();
                double ssdPrice = selectedSSD.getPrice();

                PowerSupply selectedPowerSupply = (PowerSupply) powerSupplySpinner.getSelectedItem();
                double powerSupplyPrice = selectedPowerSupply.getPrice();

                totalPrice = processorPrice + motherboardPrice + ramPrice + graphicsCardPrice + ssdPrice + powerSupplyPrice;
                totalPriceTextView.setText(String.valueOf(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when nothing is selected
            }
        });
    }

        public class Processor {
        private String name;
        private double price;

        public Processor(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + price + ")";
        }
    }

    public class Motherboard {
        private String name;
        private double price;

        public Motherboard(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + price + ")";
        }
    }

    public class RAM {
        private String name;
        private double price;

        public RAM(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + price + ")";
        }
    }
    public class GraphicsCard {
        private String name;
        private double price;

        public GraphicsCard(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + price + ")";
        }
    }
    public class SSD {
        private String name;
        private double price;

        public SSD(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Геттеры и сеттеры для полей name и price

        @Override
        public String toString() {
            return name + " (" + price + ")";
        }
        public double getPrice() {
            return price;
        }
    }
    public class Cooling {
        private String name;
        private double price;

        public Cooling(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String toString() {
            return name + " (" + price + ")";
        }
    }
    public static class PowerSupply {
        private String name;
        private double price;

        public PowerSupply(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + price + ")";
        }
    }

}