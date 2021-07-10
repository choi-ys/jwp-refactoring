package kitchenpos.repository;

import kitchenpos.domain.TableGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTableGroupRepository extends JpaRepository<TableGroup, Long> {

}
