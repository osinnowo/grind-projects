from models import User, Gender, Role
from typing import List
from uuid import uuid4

database: List[User] = [
    User(
        id=uuid4(),
        first_name="Emmanuel",
        last_name="Osinnowo",
        middle_name="Itunu",
        gender=Gender.male,
        roles=[Role.student, Role.admin]
    ),
    User(
        id=uuid4(),
        first_name="Jamie",
        last_name="Anselm",
        middle_name="Jude",
        gender=Gender.male,
        roles=[Role.student]
    ),
    User(
        id=uuid4(),
        first_name="Ami",
        last_name="Michelle",
        middle_name="Brown",
        gender=Gender.female,
        roles=[Role.student, Role.user, Role.admin]
    )
]