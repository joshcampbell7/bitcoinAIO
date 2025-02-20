package com.bitcoin.bitcoinaio.controller;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.script.Script;
import org.bitcoinj.wallet.KeyChainGroupStructure; // Add this import
import org.bitcoinj.wallet.Wallet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private  NetworkParameters networkParameters = TestNet3Params.get();

    @GetMapping("/test")
    public ResponseEntity<String> createWallet() {
        Wallet wallet = Wallet.createDeterministic(networkParameters, Script.ScriptType.P2PKH);
        String address = wallet.freshReceiveAddress().toString(); // Use freshReceiveAddress instead
        return ResponseEntity.ok("New Wallet Address: " + address);
    }

}