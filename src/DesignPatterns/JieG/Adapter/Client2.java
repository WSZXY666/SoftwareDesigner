package DesignPatterns.JieG.Adapter;

import java.util.*;

class Address {
    public void street() { /* 实现代码省略 */ }

    public void zip() { /* 实现代码省略 */ }

    public void city() { /* 实现代码省略 */ }
    // 其他成员省略
}

class DutchAddress {
    public void straat() { /* 实现代码省略 */ }

    public void postcode() { /* 实现代码省略 */ }

    public void plaats() { /* 实现代码省略 */ }
    // 其他成员省略
}

class DutchAddressAdapter extends DutchAddress {
    private Address address; // (1)

    public DutchAddressAdapter(Address addr) {
        address = addr;
    }

    @Override
    public void straat() {
        address.street(); // (2)
    }

    @Override
    public void postcode() {
        address.zip(); // (3)
    }

    @Override
    public void plaats() {
        address.city(); // (4)
    }
    // 其他成员省略
}

class Client2 {
    public static void main(String[] args) {
        Address addr = new Address();
        DutchAddress addrAdapter = new DutchAddressAdapter(addr); // (5)
        System.out.println("\n The DutchAddress\n");
        testDutch(addrAdapter);
    }

    static void testDutch(DutchAddress addr) {
        addr.straat();
        addr.postcode();
        addr.plaats();
    }
}
