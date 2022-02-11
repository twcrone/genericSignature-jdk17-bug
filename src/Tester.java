/*
 *
 *  * Copyright 2021 New Relic Corporation. All rights reserved.
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tester {

    public static void main(String... args) throws Throwable {

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandles.Lookup classLookup = MethodHandles.privateLookupIn(Class.class, lookup);
        MethodHandle getGenericSignature0 = classLookup.findVirtual(Class.class, "getGenericSignature0", MethodType.methodType(String.class));
        Object genericSignature = getGenericSignature0.invoke(CompletableFuture.class);

        System.out.println();
        System.out.println("getGenericSignature0: " + genericSignature);
        System.out.println("expected: <T:Ljava/lang/Object;>Ljava/lang/Object;Ljava/util/concurrent/Future<TT;>;Ljava/util/concurrent/CompletionStage<TT;>;");
        System.out.println();

        Type type = Tester.class.getDeclaredMethod("testing").getGenericReturnType();
        System.out.println("TYPE: " + type);
    }

    public CompletableFuture<List<String>> testing() {
        return null;
    }
}
