package org.example.foo.bitcoinrate.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BitcoinRatio(@NotNull @Size(min = 3, max = 3) String currency, String value) {

}
