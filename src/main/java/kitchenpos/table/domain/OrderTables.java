package kitchenpos.table.domain;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Embeddable
public class OrderTables {

    @OneToMany(mappedBy = "tableGroup", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<OrderTable> orderTables = new ArrayList<>();

    protected OrderTables() {
    }

    public void addOrderTables(List<OrderTable> orderTables) {
        validateAddOrderTables(orderTables);

        orderTables.forEach(this::addOrderTable);

        if (orderTables.size() <= 1) {
            throw new IllegalArgumentException("테이블이 2개이상 존재해야 합니다.");
        }
    }

    private void validateAddOrderTables(List<OrderTable> orderTables) {
        requireNonNull(orderTables, "테이블이 존재하지 않습니다.");
        if (orderTables.isEmpty()) {
            throw new IllegalArgumentException("테이블이 존재하지 않습니다.");
        }
    }

    private void addOrderTable(OrderTable orderTable) {
        requireNonNull(orderTable, "테이블이 존재하지 않습니다.");

        this.orderTables.add(orderTable);
    }

    public List<OrderTable> getOrderTables() {
        return orderTables;
    }

}
