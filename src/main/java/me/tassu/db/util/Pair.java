package me.tassu.db.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pair<A, B> {

    private A a;
    private B b;

    @Override
    public int hashCode() {
        return 31 * a.hashCode() + b.hashCode();
    }

}
