package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream().map(profile -> profile.getAddress()).distinct().collect(Collectors.toList());
        result.sort(Comparator.comparing(Address::getCity));
        return result;
    }
}
