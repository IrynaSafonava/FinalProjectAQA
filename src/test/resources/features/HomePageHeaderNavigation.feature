Feature: As a user I want to navigate site via header submenu options.

  @smoke
  Scenario: Navigation header submenu of 'Автобарахолка' contains options.
    Given user navigates home page
    When user hovers 'Автобарахолка' category in header
    Then submenu with options appears
      | Гомель            |
      | Брест             |
      | Минск             |
      | BMW               |
      | Audi              |
      | Авто до 4000 р.   |
      | Авто до 10 000 р. |

  @smoke
  Scenario: Navigation header submenu of 'Дома и квартиры' contains options.
    Given user navigates home page
    When user hovers 'Дома и квартиры' category in header
    Then submenu with options appears
      | Гомель          |
      | Брест           |
      | Минск           |
      | 1-комнатные     |
      | 2-комнатные     |
      | 4+-комнатные    |
      | До 30 000 $     |
      | 30 000–80 000 $ |
      | От 80 000 $     |