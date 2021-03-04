

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.simple.*;
import org.json.simple.parser.*;

public class test {



    public static void main(String[] args) throws MalformedURLException, IOException {
        String sURL = "https://api.coingecko.com/api/v3/simple/price?ids=elrond-erd-2%2Cbitcoin%2Ctether%2Cethereum&vs_currencies=" +
                "usd&include_market_cap=false&include_24hr_vol=false&include_24hr_change=false&include_last_updated_at=false\n";
        URL url = new URL(sURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();


        JsonParser jp = new JsonParser(); //from gson

        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();

        System.out.println(rootobj.toString());
        ObjectMapper om = new ObjectMapper();
        Roott roott = om.readValue(rootobj.toString(), Roott.class);


        System.out.println(roott.getEthereum().getUsd() * 10);

    }


    public static class ElrondErd2{
        @JsonProperty("usd")
        public double getUsd() {
            return this.usd; }
        public void setUsd(double usd) {
            this.usd = usd; }
        double usd;

    }

    public static class Tether{
        @JsonProperty("usd")
        public double getUsd() {
            return this.usd; }
        public void setUsd(double usd) {
            this.usd = usd; }
        double usd;

    }

    public static class Bitcoin{
        @JsonProperty("usd")
        public double getUsd() {
            return this.usd; }
        public void setUsd(double usd) {
            this.usd = usd; }
        double usd;

    }

    public static class Ethereum{
        @JsonProperty("usd")
        public double getUsd() {
            return this.usd; }
        public void setUsd(double usd) {
            this.usd = usd; }
        double usd;

    }

    public static class Roott{
        @JsonProperty("elrond-erd-2")
        public ElrondErd2 getElrondErd2() {
            return this.elrondErd2; }
        public void setElrondErd2(ElrondErd2 elrondErd2) {
            this.elrondErd2 = elrondErd2; }
        ElrondErd2 elrondErd2;
        @JsonProperty("tether")
        public Tether getTether() {
            return this.tether; }
        public void setTether(Tether tether) {
            this.tether = tether; }
        Tether tether;
        @JsonProperty("bitcoin")
        public Bitcoin getBitcoin() {
            return this.bitcoin; }
        public void setBitcoin(Bitcoin bitcoin) {
            this.bitcoin = bitcoin; }
        Bitcoin bitcoin;
        @JsonProperty("ethereum")
        public Ethereum getEthereum() {
            return this.ethereum; }
        public void setEthereum(Ethereum ethereum) {
            this.ethereum = ethereum; }
        Ethereum ethereum;
    }

}
